# 원작자: Shayan925 깃허브 링크: https://github.com/Shayan925/ADHD-Aid
import cv2
import mediapipe as mp
import numpy as np
import time
import os
from datetime import datetime
import csv
from PIL import ImageFont, ImageDraw, Image
from util import calc_center, eye_direction, warn, log_focus_loss, log_focus_regain

os.environ["CUDA_VISIBLE_DEVICES"] = "-1"

# Indices for the left and right eye
LEFT_EYE = [362, 382, 381, 380, 374, 373, 390,
            249, 263, 466, 388, 387, 386, 385, 384, 398]
RIGHT_EYE = [33, 7, 163, 144, 145, 153, 154,
             155, 133, 173, 157, 158, 159, 160, 161, 246]

# Indices for the left and right iris
LEFT_IRIS = [474, 475, 476, 477]
RIGHT_IRIS = [469, 470, 471, 472]

mpFace = mp.solutions.face_mesh

# Capture video input from any source
cap = cv2.VideoCapture(0)

face_mesh = mpFace.FaceMesh(max_num_faces=1,
                            refine_landmarks=True,
                            min_detection_confidence=0.9,
                            min_tracking_confidence=0.7)

# Initialize log.csv
with open("log.csv", "w", newline='') as f:
    writer = csv.writer(f)
    writer.writerow(["lost", "regained"])

t1 = time.time()
warned = False

fontpath = "fonts/malgunbd.ttf"
font = ImageFont.truetype(fontpath, 32)

while True:
    success, img = cap.read()

    if not success:
        break

    # Process image
    img = cv2.flip(img, 1)
    imgRGB = cv2.cvtColor(img, cv2.COLOR_BGR2RGB)
    h, w, c = img.shape
    results = face_mesh.process(imgRGB)

    # Find landmarks
    if results.multi_face_landmarks:
        # Find points
        points = np.array([np.multiply([p.x, p.y], [w, h]).astype(
            int) for p in results.multi_face_landmarks[0].landmark])

        # Calculate the center point of both irises and eyes
        left_iris_center = calc_center(LEFT_IRIS, points, img, True)
        right_iris_center = calc_center(RIGHT_IRIS, points, img, True)

        left_eye_center = calc_center(LEFT_EYE, points, img)
        right_eye_center = calc_center(RIGHT_EYE, points, img)

        # Determine the direction the eye is looking and display the text
        eye1 = eye_direction(left_iris_center, left_eye_center)
        eye2 = eye_direction(right_iris_center, right_eye_center)

        if eye1 == eye2:
            direction = eye1
        else:
            direction = eye1 if eye1 != "CENTER" else eye2

        img_pil = Image.fromarray(img)
        draw = ImageDraw.Draw(img_pil)
        draw.text((10, 430), "방향: " + direction, font=font, fill=(255, 255, 255, 0))
        img = np.array(img_pil)


        # If user's eyes are not in the center for more than 2 seconds warn them
        if direction == "CENTER":
            t1 = time.time()
            
            if warned:
                warned = False
                log_focus_regain()

        elif direction != "CENTER" and not warned:
            t2 = time.time()
            if t2 - t1 > 0.5:
                warn(img)
                warned = True
                log_focus_loss()

    # If face is off the screen for longer than 2 seconds it will warn the user
    else:
        if not warned:
            t2 = time.time()
            if t2 - t1 > 0.5:
                warn(img)
                warned = True
                log_focus_loss()

    # If warned, check if eyes are back to center
    if warned:
        results = face_mesh.process(cv2.cvtColor(img, cv2.COLOR_BGR2RGB))
        if results.multi_face_landmarks:
            points = np.array([np.multiply([p.x, p.y], [w, h]).astype(
                int) for p in results.multi_face_landmarks[0].landmark])
            left_iris_center = calc_center(LEFT_IRIS, points, img, True)
            right_iris_center = calc_center(RIGHT_IRIS, points, img, True)
            left_eye_center = calc_center(LEFT_EYE, points, img)
            right_eye_center = calc_center(RIGHT_EYE, points, img)
            eye1 = eye_direction(left_iris_center, left_eye_center)
            eye2 = eye_direction(right_iris_center, right_eye_center)
            if eye1 == "CENTER" and eye2 == "CENTER":
                log_focus_regain()
                warned = False

    cv2.imshow("ADHD Aid", img)
    cv2.waitKey(1)

    # Click the "X" icon to close window
    if cv2.getWindowProperty("ADHD Aid", cv2.WND_PROP_VISIBLE) < 1:
        break

cap.release()
cv2.destroyAllWindows()
