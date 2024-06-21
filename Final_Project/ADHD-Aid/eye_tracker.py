import cv2
import mediapipe as mp
import numpy as np
import time
import os
import pandas as pd

from datetime import datetime
from util import calc_center, eye_direction, warn
from PIL import ImageFont, ImageDraw, Image

os.environ["CUDA_VISIBLE_DEVICES"] = "-1"

LEFT_EYE = [362, 382, 381, 380, 374, 373, 390, 249, 263, 466, 388, 387, 386, 385, 384, 398]
RIGHT_EYE = [33, 7, 163, 144, 145, 153, 154, 155, 133, 173, 157, 158, 159, 160, 161, 246]
LEFT_IRIS = [474, 475, 476, 477]
RIGHT_IRIS = [469, 470, 471, 472]

mpFace = mp.solutions.face_mesh

cap = cv2.VideoCapture(0)
if not cap.isOpened():
    print("Error: Could not open video capture device.")
    exit()

face_mesh = mpFace.FaceMesh(max_num_faces=1, refine_landmarks=True, min_detection_confidence=0.9, min_tracking_confidence=0.7)

t1 = time.time()
warned = False

# 한글 폰트 설정 (경로는 시스템에 따라 다를 수 있음)
fontpath = "fonts/gulim.ttc"  # 한글 폰트 파일 경로
font = ImageFont.truetype(fontpath, 32)

window_name = "ADHD Aid"
cv2.namedWindow(window_name, cv2.WINDOW_NORMAL)

while True:
    success, img = cap.read()

    if not success:
        print("Error: Could not read frame.")
        break

    img = cv2.flip(img, 1)
    imgRGB = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    h, w, c = img.shape
    results = face_mesh.process(imgRGB)

    if results.multi_face_landmarks:
        points = np.array([np.multiply([p.x, p.y], [w, h]).astype(int) for p in results.multi_face_landmarks[0].landmark])
        left_iris_center = calc_center(LEFT_IRIS, points, img, True)
        right_iris_center = calc_center(RIGHT_IRIS, points, img, True)
        left_eye_center = calc_center(LEFT_EYE, points, img)
        right_eye_center = calc_center(RIGHT_EYE, points, img)

        eye1 = eye_direction(left_iris_center, left_eye_center)
        eye2 = eye_direction(right_iris_center, right_eye_center)

        if eye1 == eye2:
            direction = eye1
        else:
            direction = eye1 if eye1 != "CENTER" else eye2

        # 한글 텍스트를 이미지에 추가
        img_pil = Image.fromarray(img)
        draw = ImageDraw.Draw(img_pil)
        draw.text((10, 450), "방향: " + direction, font=font, fill=(255, 255, 255, 0))
        img = np.array(img_pil)

        if direction == "CENTER":
            t1 = time.time()
            if warned:
                warned = False
                now = datetime.now()
                cur_time = now.strftime("%H:%M:%S")
                log_df = pd.DataFrame({"Time": [cur_time], "Event": ["User has regained focus"]})
                log_df.to_csv("log.csv", mode="a", header=False, index=False)
        elif direction != "CENTER" and not warned:
            t2 = time.time()
            if t2 - t1 > 0.5:
                warn(img)
                warned = True

    else:
        if not warned:
            t2 = time.time()
            if t2 - t1 > 0.5:
                warn(img)
                warned = True

    cv2.imshow(window_name, img)
    if cv2.getWindowProperty(window_name, cv2.WND_PROP_VISIBLE) < 1:
        break

    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cap.release()
cv2.destroyAllWindows()
