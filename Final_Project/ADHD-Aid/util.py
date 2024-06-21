import cv2
import numpy as np
import winsound
from datetime import datetime
import pandas as pd
import csv
import win32gui
import win32con
import pyautogui
import time

window_name = "ADHD Aid"
cv2.namedWindow(window_name, cv2.WINDOW_NORMAL)

# Determine the center point of the given shape
def calc_center(indexes, points, img, draw=False):
    (cx, cy), radius = cv2.minEnclosingCircle(points[indexes])
    center = np.array([cx, cy], dtype=np.int32)

    if draw:
        cv2.circle(img, center, int(radius), (0, 0, 255), 1, cv2.LINE_AA)

    print(f"calc_center called with center: {center}, radius: {radius}")
    return center

# Determine the direction of the eye
def eye_direction(iris_center, eye_center):
    print(f"eye_direction called with iris_center: {iris_center}, eye_center: {eye_center}")
    if abs(iris_center[0] - eye_center[0]) < 5:
        return "CENTER"
    elif iris_center[0] - eye_center[0] < 0:
        return "LEFT"
    elif iris_center[0] - eye_center[0] > 0:
        return "RIGHT"

# Play the audio file
def play_sound():
    audio_file = "warning.wav"
    print("play_sound called")
    winsound.PlaySound(audio_file, winsound.SND_FILENAME)

def bring_window_to_front(window_name):
    hwnd = win32gui.FindWindow(None, window_name)
    if hwnd:
        # Alt + Tab 입력 시뮬레이션
        pyautogui.keyDown('alt')
        pyautogui.press('tab')
        pyautogui.keyUp('alt')
        time.sleep(0.5)  # 잠시 대기

        win32gui.SetForegroundWindow(hwnd)
        win32gui.ShowWindow(hwnd, win32con.SW_RESTORE)

# Warn the user and the supervisor that their attention is elsewhere
# and should pay attention to the screen
def warn(img):

    bring_window_to_front(window_name)
    
    h, w, c = img.shape
    cv2.rectangle(img, (0, 0), (w, h), (0, 0, 255), -1)
    cv2.putText(img, "You have lost focus", (150, 250), cv2.FONT_HERSHEY_PLAIN, 2, (255, 255, 255), 4)
    cv2.imshow(window_name, img)
    cv2.waitKey(5000)

    play_sound()

    # Record when the user first loses focus into log.csv
    now = datetime.now()
    cur_time = now.strftime("%H:%M:%S")
    print(f"warn called at {cur_time}")

    log_df = pd.DataFrame({"Time": [cur_time], "Event": ["User has lost focus"]})
    log_df.to_csv("log.csv", mode="a", header=False, index=False)

def log_focus_loss():
    now = datetime.now()
    cur_time = now.strftime("%H:%M:%S")

    with open("log.csv", "r", newline = '') as f:
        rows = list(csv.reader(f))

    if rows and rows[-1][0] == cur_time and rows[-1][1] == "":
        return
    
    with open("log.csv", "a", newline='') as f:
        writer = csv.writer(f)
        writer.writerow([cur_time, ""])

def log_focus_regain():
    now = datetime.now()
    cur_time = now.strftime("%H:%M:%S")

    with open("log.csv", "r", newline='') as f:
        rows = list(csv.reader(f))

    if rows and rows[-1][1] == "":
        rows[-1][1] = cur_time

    with open("log.csv", "w", newline='') as f:
        writer = csv.writer(f)
        writer.writerows(rows)


    

