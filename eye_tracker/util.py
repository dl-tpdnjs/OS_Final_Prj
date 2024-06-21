# 원작자: Shayan925 깃허브 링크: https://github.com/Shayan925/ADHD-Aid
import cv2
import numpy as np
import winsound
from datetime import datetime
import csv
from PIL import ImageFont, ImageDraw, Image
import threading
import win32gui
import win32con
import pyautogui
import time

fontpath = "fonts/malgunbd.ttf"
fontpath2 = "fonts/malgun.ttf"
font = ImageFont.truetype(fontpath, 32)
font2 = ImageFont.truetype(fontpath2, 22)

window_name = "ADHD Aid"
cv2.namedWindow(window_name, cv2.WINDOW_NORMAL)

# Determine the center point of the given shape
def calc_center(indexes, points, img, draw=False):
    (cx, cy), radius = cv2.minEnclosingCircle(points[indexes])
    center = np.array([cx, cy], dtype=np.int32)

    if draw:
        cv2.circle(img, center, int(radius), (65,255,58), 1, cv2.LINE_AA)

    return center

# Determine the direction of the eye
def eye_direction(iris_center, eye_center):
    if abs(iris_center[0] - eye_center[0]) < 5:
        return "CENTER"
    elif iris_center[0] - eye_center[0] < 0:
        return "LEFT"
    elif iris_center[0] - eye_center[0] > 0:
        return "RIGHT"

# Play the audio file in a separate thread
def play_sound():
    audio_file = "warning.wav"
    winsound.PlaySound(audio_file, winsound.SND_FILENAME)

def bring_window_to_front(window_name):
    hwnd = win32gui.FindWindow(None, window_name)
    if hwnd:
        pyautogui.keyDown('alt')
        pyautogui.press('tab')
        pyautogui.keyUp('alt')
        time.sleep(0.5)
        win32gui.SetForegroundWindow(hwnd)
        win32gui.ShowWindow(hwnd, win32con.SW_RESTORE)

# Warn the user and the supervisor that their attention is elsewhere 
# and should pay attention to the screen
def warn(base_img):
    bring_window_to_front(window_name)
    h, w, c = base_img.shape
    cv2.rectangle(base_img, (0, 0), (w, h), (0, 0, 255), -1)

    # Start the sound in a separate thread
    threading.Thread(target=play_sound).start()
    
    for remaining_time in range(10, 0, -1):
        img = base_img.copy()  # Reset the image to the base each time
        img_pil = Image.fromarray(img)
        draw = ImageDraw.Draw(img_pil)
        draw.text((30, 230), "10초 내에 다시 영상 강의에 집중하세요!", font=font, fill=(255, 255, 255, 255))
        draw.text((245, 400), f"남은 시간: {remaining_time}초", font=font2, fill=(255, 255, 255, 255))
        img = np.array(img_pil)

        # Load the small warning image
        warning_image = cv2.imread('warning.png', cv2.IMREAD_UNCHANGED)
        
        if warning_image is not None:
            # Resize the warning image to a smaller size if needed
            warning_image = cv2.resize(warning_image, (200, 200))  # Adjust the size as needed
            
            # Determine the position to place the small image (top-left corner here)
            y_offset = 10
            x_offset = 230
            
            y1, y2 = y_offset, y_offset + warning_image.shape[0]
            x1, x2 = x_offset, x_offset + warning_image.shape[1]

            if warning_image.shape[2] == 4:
                # If the image has an alpha channel, blend it with the background
                alpha_s = warning_image[:, :, 3] / 255.0
                alpha_l = 1.0 - alpha_s

                for c in range(0, 3):
                    img[y1:y2, x1:x2, c] = (alpha_s * warning_image[:, :, c] + alpha_l * img[y1:y2, x1:x2, c])
            else:
                img[y1:y2, x1:x2] = warning_image

        # Display the warning message
        cv2.imshow("ADHD Aid", img)
        cv2.waitKey(1000)

    # Record when the user first loses focus into log.csv
    log_focus_loss()

def log_focus_loss():
    now = datetime.now()
    cur_time = now.strftime("%H:%M:%S")
    
    # Read the existing data and check if the last entry is a "lost" entry
    with open("log.csv", "r", newline='') as f:
        rows = list(csv.reader(f))


    if rows and rows[-1][0] == cur_time and rows[-1][1] == "":
        return  # Do not log duplicate "lost" entries

    with open("log.csv", "a", newline='') as f:
        writer = csv.writer(f)
        writer.writerow([cur_time, ""])

def log_focus_regain():
    now = datetime.now()
    cur_time = now.strftime("%H:%M:%S")
    
    # Read the existing data and update the last row
    with open("log.csv", "r", newline='') as f:
        rows = list(csv.reader(f))

    if rows and rows[-1][1] == "":
        rows[-1][1] = cur_time

    # Write the updated data back to the file
    with open("log.csv", "w", newline='') as f:
        writer = csv.writer(f)
        writer.writerows(rows)
