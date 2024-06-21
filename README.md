# 👀 ADHD인들을 위한 온라인(사이버) 강의 집중 보조 프로그램 README
- (이거 확인하시면 괄호(중제목이나 제가 직접 승채님이나 세원님께 말하는 것 같은 내용은 다 지우고 저장해주시면 될 것 같아요! 이것도 지워야 겠죠??))



## 프로젝트 개발 배경

- adhd는 주의력결핍 과잉행동장애(Attention-Deficit Hyperactivity Disorder)의 약자로, 주의력이 부족하여 과다활동, 충동성 등을 보이는 상태를 말한다. 건강보험공단에 따르면 장기적 추적 연구 결과 ADHD를 겪는 아동의 60% 이상이 성인이 되어서도 증상을 경험하는 것으로 알려져 있다.

- 특정 대상에 대한 집중도를 측정하는 선택적 집중력 테스트에서 ADHD 환자들은 시선 분포가 더 넓고, 목표물에 시선을 고정하는 시간이 더 짧은 것으로 나타났다.

- ADHD 환자들에게서 나타나는 주의력 결핍, 반응 억제의 실패 등은 안구 운동을 통해 즉각적으로 나타난다. 또한 안구 운동의 측정을 통해 운동 능력으로 인해 발생하는 측정치 오염이 최소화된 데이터를 얻을 수 있다. 




<br>

## 프로젝트 기술 개발 목적
- 해당 프로젝트는 사이버 강의 집중력을 향상시키도록 동공 트래킹을 이용한다. ADHD인 성인이 자신의 사이버 강의 성취 정도를 확인하여 동기를 부여하는 데 기여한다.

- 집중력은 사이버 강의를 볼 때의 안구운동을 동공 트래킹을 이용해서 측정하고, 성취도를 강의 시간과 집중 시간으로 나눠서 강의 집중 비율로 표시하여 기록한다. 
    : 성취의 미달이나 집중의 실패를 기록하여 사용자가 확인할 수 있기 때문에, 사용자의 동기 부여와 개인 학습 능력을 향상시키는 데에 기여할 수 있을 것이다.

- ADHD 사용자가 주의 집중이 부족하여 집중을 하지 않는다고 판단되면, 적절한 알림이나 경고, 기록되는 보고서에 어떤 부분에서 집중이 부족했는지를 알려준다.
    : 이를 통해 사용자가 자신이 집중력이 부족했던 시간을 파악하여 다시 복습할 수 있어서 학습의 동기 부여가 될 수 있게 한다.




<br>

## 프로젝트 기술적 기대효과
- ADHD인들의 사이버 집중력 향상에 크게 도움이 될 것이다. 
    - 특히 사이버 강의는 지속적인 주의와 억제 능력 측정이 매우 중요하다. 하지만 ADHD 인의 부주의하고 충동적인 특성이 누락오류율과 오경보오류율로 나타나게 되어 억제 능력이 줄어들기 때문에, 억제가 없는 사이버 강의를 듣는 것이 비조직적인 상황처럼 느낄 수 있다. 이에 시선을 통해 도움을 주는 것이 억제된 상황을 만들어주기에 ADHD가 있는 성인에게 도움이 될 것이다.

    - 이러한 상황에서 안구 운동에 의한 안구 움직임으로 ADHD의 자기 조절 및 억제 능력을 측정하고 제한하면서 사이버 강의를 듣는 데 필요한 집중력을 기르는데 큰 도움을 줄 수 있을 것이라고 생각한다.




<br>

## 팀원 구성

<div align="center">

| **🦈 이세원** | **👻 김주연** | **🌠 송하은** | **🐬 이승채** |
| :-------: |  :-------: | :-------:  | :-------: |
|팀장/벡엔드|프론트엔드/데이터관리|프론트엔드/데이터관리|벡엔드/데이터관리|




</div>





<br>

## 1. 개발 환경
- Front : Java(IntelliJ)
- Back-end : 오픈소스 API(GitHub), Python(VsCode)
- 버전 및 이슈관리 : Github, Notion
- 협업 툴 : GoogleMeet, Notion, Github,



<br>

## 2. 채택한 개발 기술과 기술 개발 전략 (사용한 오픈소스에 대한 설명이 들어가고, 저희가 어떻게 개발을 진행했는지, 즉 최종보고서에 있는 '연구개발 내용'이 들어가면 될 것으로 보입니다.)

(개발 서비스 목표 및 기능 개발/구현에 대한 세부 내용을 서술함. 사용한 기술과 소스 및 개발에 사용한 툴 등을 포함하되 알고리즘 중심으로 최종 UI 기능 구현까지 서술할 것. 만약 하드웨어를 사용한 팀은 하드웨어 부분도 서술해 줄 것)


### 오픈소스 기술 : 동공 트래킹 기술 설명 💡

- 동공 트래킹 알고리즘(OPEN CV)
    - OpenCV는 Computer Vision 프로그래밍을 쉽게 할 수 있도록 도와주는 라이브러리로 실시간 영상처리, 3D 구성, 추적, 기계학습 그리고 딥러닝까지 유용한 기능이 매우 많다. 이에 이미지 처리 작업을 수행하고 정보를 추출해내기 위해서 필요한 도구를 해당 라이브러리에서 알고리즘을 통해 구현할 예정
    - 추가로 라이브러리를 통해 카메라에서 비디오 입력을 받고 그 위에 텍스트나 선, 도형을 그려 동공 추적 기술을 오버레이로 시각화하여 구현할 것임.

    1. 얼굴 인식 및 랜드마크 감지하여 양쪽 동공 및 눈의 중심점을 계산

        - 카메라로 영상을 캡쳐해서 MediaPipe를 이용해, 얼굴을 인식하고 사용자의 얼굴 랜드마크(눈, 코, 입 등)를 검출하는 것으로 눈과 동공에 해당하는 인덱스를 정의한다.

        - 해당 기능을 바탕으로 얼굴 검출과 동일한 방법으로 좌우 각각의 눈 영영을 검출하고, 각 눈의 랜드마크를 기반으로 동공의 위치를 추정하여 동공의 중심점을 계산한다.

    2. 동공 중심점 계산하여 시각화하여 표시: 주로 이미지 상의 특정 구조나 객체의 중심 위치를 찾는데에 사용하는 것으로, 해당 프로젝트에서는 눈동자의 중심을 계산하기 위해서 사용한다.

        - 원을 계산할 이미지 상의 특정 점들의 인덱스를 받고, 주어진 점의 배열에서 면적으로 모든 점을 포함할 수 있는 가장 작은 영역을 원으로 계산하여 표시할 것이다.

        - 이를 통하여 눈의 위치를 시각적으로 표현하도록 했다.

    3. 눈의 시선 방향 검출 : 홍채가 움직이는 방향을 파악하기 위해 움직이지 않는 기준점을 찾고 홍체 중심으로부터 떨어진 수평 및 수직 거리를 계산하여, 눈이 어느 방향으로 향하고 있는지를 파악해 사용자의 시선을 추적하도록 할 것이다.

        - 이 기술에서 사용자의 시선을 추적하는 데에 여러가지 문제점(사용자가 시선이 벗어난 순간에만 메시지를 띄우고, 그 외의 경우에는 띄우지 않는 경우 등)을 줄이기 위해서 코드 개선을 진행였다.

    4. 사용자의 주의력 경고 : 위에서 경고 메세지를 출력하는 것으로 그치는 것이 아닌, 사용자의 집중 유지를 위해서 warn 함수를 사용해서 집중 유지 시간을 표시하고 집중 유지 시간에 대해서 10초 이내로 집중하면 집중 유지 시간을 유지하고 하지 못하면 초기화하는 방식으로 진행하였다.

        - 경고 메시지 표시 : 전체 이미지를 웹캠에 빨간색으로 채워 사용자에게 “ You have lost focus “라는 문구가 가운데에 오도록 메시지를 이미지 중앙에 표시하도록 한다.
            - 우리가 개발할 기술에서 사용자의 주의 집중을 유지하도록 해주는 데에 가장 큰 역할을 해주는 기능으로 벡엔드 부분에서 해당 부분에 대한 개량이 들어갔다.
            - 해당 메시지가 유지되는 시간을 늘리고, 플로팅 화면의 문구/시간 변화를 추가해주는 방식으로 개량을 진행했다.
    
    5. 사용자의 집중도 결과 표시
    
        - 집중력 점수는 세션 전반에 걸쳐 사용자의 눈 움직임을 기반으로 계산한다. 이러한 결과를 실시간으로 화면에 표시했다.

        - eye_direction 함수를 이용하여 홍채 중심 좌표와 눈 중심 좌표의 차이에 따라 시선 방향을 결정하고, play_sound 함수를 통해 경우의 수에 따라 사용자의 집중도를 올려주기 위한 소리를 출력하도록 했다.

<br>

### 오픈소스 기술 개량 
1. 조건 설정
   - 기존의 동공추적 기술은 사용자가 2초간 정면이 아닌 오른쪽과 왼쪽을 응시해야 경고창이 뜨도록 설정이 되어있었다. 여기서 2초가 길다고 판단이 되었기 때문에, 2초가 아닌, 0.5초간 정면이 아닌 곳을 응시했을 때 경고창이 뜨도록 수정하였다.
     
2. 데이터 전달
    - 사용자가 집중력을 잃은 시간과 집중력을 다시 회복한 시간을 log.txt에 기록하도록 되어있었다. 하지만 라벨링을 통해 해당 정보를 프론트 측에 더 쉽게 넘겨주기 위해 txt파일이 아닌, csv파일에 입력되도록 변경하였다. 또한, 기존에는 입력된 값들이 프로그램을 재실행 하더라도 계속해서 누적이 되었다. 따라서, 이 부분을 프로그램을 재실행하면, 이전 프로그램 실행 시 입력되었던 값들이 리셋되도록 하였다. 그리하여 입력값들을 프론트측으로 넘겨주었을 때, 혼란이 없도록 프로그램을 한번 실행할 때, 즉 강의 하나에 대해서만 입력값들이 전달되도록 하였다.
      
3. 창 전환
   -기존의 프로그램은 동공 추적 창과 경고창 전환만이 구현되어 있었다. 그러나, 온라인 강의 특성 상 전체 화면을 강의 영상 창으로 채워야 하므로 프로그램 창의 위치에 대한 곤란함이 있었다. 따라서, pyautogui와 pywin32를 사용하여 강의를 재생할 때는 웹캠화면(동공추적 화면)이 뒤에 뜨도록 하여 사용자가 웹캠화면으로 방해받지 않고, 강의에 집중할 수 있도록 하다가, 경고창이 뜨는 시점에만, 강의창에 가려져 보이지 않았던 eye_tracker창이 화면의 가장 앞으로 노출되도록 하였다.
   
4. 경고창
   - 기존의 경고창은, 음성과 함께 "You have lost focus"라는 문구가 뜨도록 하였다. 여기서 opencv에서는 한국어를 지원하지 않고 있어, ~~모듈을 이용하여 한국어로 "10초 내에 다시 영상 강의에 집중하세요!" 라는 문구로 수정하였다. 또한, 동공을 추적하는 웹캠 창에서도 현재 동공의 방향을 표시하도록 되어 있는데 여기서도 방향 표시 부분을 한국어로 문구를 수정하여 사용자가 조금 더 이해하기 쉽도록 개선하였다.
   - 또한, 주의 집중을 요하는 경고 이미지를 경고창에 함께 뜨도록 하였다. 또한, 경고 메시지가 뜨게 함으로서, 다시 집중을 할 수 있도록 돕는 것이 목적이므로, 경고 창이 표시되는 시간을 10초로 변경하여 10초동안 다시 집중 상태로 돌아갈 수 있는 준비를 할 수 있도록 한다. 경고메시지는 10초가 지나면 사라지므로, 사용자는 10초동안은 다시 집중을 유지하는 준비를 해야한다. 때문에, 사용자에게 경고창이 사라지기까지 몇 초가 남았는지 남은 시간을 알려줄 수 있도록 10초부터 카운트다운을 하는 부분을 추가하였다.
   - 기존에는 경고 메시지가 나타난 시점부터를 집중력을 잃은 시간으로 측정이 되었고, 집중을 잃은 시간에서부터 집중을 회복하기까지의 시간이 0초, 또는 1초 정도의 아주 간소한 차이로, 사용자의 집중도 측정이 제대로 되지 않는다는 것을 파악했다. 또한, 10초 내에 집중을 다시 유지하면 집중 시간이 유지되도록 하였던 본래 목적을 반영하여, 10초가 지나 경고창이 사라진 이후부터를 집중력을 잃은 시간으로 측정하고, 경고창이 사라지고 난 후 CENTER를 보기까지의 시간을 집중력을 회복한 시점이라고 측정하여 CENTER를 바로 바라보았다면 (log.csv에 입력된 lost_end - lost_strat의 값이 0이라면,)집중이 유지되었다고 보고, (log.csv에 입력된 lost_end - lost_start > 0 ) 이면, CENTER를 바라보기까지 약간의 시간이 걸렸다면, 그 시간을 집중력이 회복된 시간으로 입력하여, 집중력을 잃은 시간을 파악하기 쉽도록 하였다.

<br>

### 오픈소스 기술과 UI의 연결 ; python 연결, csv 파일 데이터 💡
- 해당 오픈소스를 활용한 프로그램은 Java를 사용하여 구현하기로 하였다. 우선 Java 프로그램 실행 시 처음으로 뜨는 시작 화면에서는 사용자가 들을 강의명과 강의 시간을 입력할 수 있으며, 해당 정보 입력 후 ‘시작’ 버튼을 클릭하면 하단에 타이머가 표시됨과 동시에 eye_tracker.py가 실행되도록 하였다. 이때 Java 프로그램에서 python 파일을 호출할 수 있도록 ProcessBuilder를 활용하였고, eye_tracker.py가 정상적으로 작동하는 가상 환경에서 해당 파일을 실행하도록 설정하였다.
- eye_tracker.py를 실행하면 사용자가 집중을 잃기 시작한 시점, 다시 집중하기 시작한 시점을 측정하여 log.txt 파일에 기록한다. 이 데이터를 Java 프로그램에서 쉽게 활용할 수 있도록 기록 방식을 변경하였다. ~~ 해당 csv 파일에서 읽어온 사용자의 집중도에 대한 데이터와, 강의명, 강의 시간, 사용자가 타이머를 실행하고 종료한 시점 등 Java 내에서 얻은 데이터를 취합하여 새로운 csv 파일(LectureLost.csv)에 기록하였다.

<br>

### 데이터 시각화 UI(보고서 기능) 💡
- 오픈소스를 이용하여 나온 집중력 손실, 회복 시점 데이터를 이용하여 ADHD 증상에 힘들어 하는 사람들에게 자신의 사이버 강의 집중도를 시각적이고 통계적으로 나타내는 것으로 사용자가 손쉽게 파악하고 개선할 수 있도록 하고자 해당 기능을 제작하게 되었다.
- 자바 라이브러리인 Java Swing, Java Awt를 이용하여 GUI 화면을 구상하는 방식으로 진행하였고, io/util/nio/text 등의 라이브러리를 이용하여 csv 파일에서 시간이나 문자열을 읽어오는 것으로 처리가 가능하도록 진행하였다.

1. 파일 내 데이터 변경시 보고서 패널이 재작성(방금 봤던 강의도 적용된 보고서 탭을 확인할 수 있음) 

    - 이전에 봤었던 강의와 ‘집중도 측정’ 패널에서 데이터를 업데이트하여 바로 직전에 확인한 강의도 보고서를 작성해주는 것이 목적이기 때문에, csv 파일에 데이터를 받아오고 결과를 출력하는 것에서 그치는게 아닌 실행 중에 파일을 계속 잃어오는 동작을 수행할 수 있도록 기능을 구현하였다. 
    
    → FileWatcher 클래스를 통해 파일 변경을 감지하면 ‘집중도 보고서’ 탭을 눌렀을 때 파일을 다시 로드하고, 로드한 파일을 다시 보고서 패널로 작성하여 붙여놓도록 하는 기능을 추가하여, 사용자가 화면이 실행 중일 때 바로바로 자신의 집중도를 확인할 수 있도록 구현하였다.

2. 각 강의에 대한 집중도 보고서 설명
    - eye_tracker.py에서 받은 집중도 데이터와 ‘집중도 측정’ 패널에서 받은 버튼 시간 데이터, 실제 강의 시간 데이터를 활용하여 사용자가 사이버 강의를 보는 동안 집중하지 못한 시간을 시각적으로 나타낼 수 있도록 하였다. eye_tracker.py의 데이터를 정제하여 저장한 LectureLost.csv에서는  lost 시간을 그 시점 시간(ex. 18:24:36)을 입력해주기 때문에 해당 데이터를 이용하기 위해서 정제가 무조건 필요했다. 이러한 문제는 시작 버튼이 눌려진 시간(Button_start)을 기준으로 빼주는 것으로 lost 시간들을 정제하여 기록할 수 있도록 했다.

        - 집중하지 못한 시간 :  사용자가 실제로 시작 버튼을 누르고 종료 버튼을 누르는 시간 동안 집중력을 잃었던 시간을 그 간격과 함께 나타내 준다.

        - 실제 강의 시간 : 사용자에게 받은 자신이 듣고 싶은 사이버 강의의 시간을 입력 받았기에 해당 내용을 표시할 수 있도록 했다.

        - 실제 강의에서 다시 복습해야할 부분 : 사용자가 강의를 끊지 않고 계속 틀어놨다고 가정하였을 경우, 실제 강의 시간을 기준으로 해당 시간 동안 집중력을 잃은 시점을 가공하여 보여줬다. 이를 통해 사용자가 자신이 어떤 부분에 있어서 집중력을 잃었는지 강의를 보면서 새로 복습을 진행할 수 있도록 했다.

        - 색깔 Bar : 실제 강의 시간은 민트색으로, 시작 - 종료 버튼을 누른 시간 간격은 베이지색으로, 집중력을 잃은 부분은 빨간색으로 표현하였다. 이를 통해 사용자가 빠르게 자신이 집중력이 잃었던 시간을 파악할 수 있다.


<br>

## 3. 설치 및 설정 방법과 사용법
### 설치 및 설정 방법

- 프로젝트 실행 전 cuda 12.5.0 / cudnn 설치(Window version)

    -  Winodow -> x86_64 -> 11 -> exe(local) 을 순서대로 누르고, 'Base Installer' 옆 버튼 Download하기
        - https://developer.nvidia.com/cuda-12-5-0-download-archive
        ![image](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/15a69b5d-4bac-4681-973e-f945d9f2d22c)


    - Winodow -> x86_64 -> Tarball -> 11 을 순서대로 누르고, 'Base Installer' 옆 버튼 Download하기
        - https://developer.nvidia.com/cudnn-downloads
        ![image](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/35c313fc-d6a4-418b-9ced-cb0c125e5fdc)



- 가상환경 설정 및 어플리케이션 실행 방법

    0. main에 있는 코드를 전체적으로 clone 또는 다운로드 하여 새로 생성한 디렉토리에 넣어둔다.

    1. 먼저 아나콘다 프롬프트를 이용하여 가상환경을 새로 만든다.

        - 가상환경 새로 만든다.
        ```
        $ conda create -n (가상환경 이름)
        ```


        - 가상환경을 활성화한다.
        ```
        $ conda activate (방금 만든 가상환경 이름)
        ```


        - 프로젝트가 있는 경로로 이동한다.
        ```
        $ cd (현재 프로젝트가 다운되어 있는 디렉토리 경로)
        ```
        

    2. 해당 위치에서 requirements.txt 파일을 통해서 필요한 라이브러리를 다 다운 받는다.
        ```
        $ pip install -r requirements.txt
        ```
        - 이 경우 이미 버전은 requirments.txt 파일 안에 다 지정되어 있으므로, 별도의 추가적인 라이브러리 설치는 하지 않아도 괜찮다.


    3. 가상 환경이 활성화되어 있는 상태에서, 자바 에디터(화자는 IntelliJ를)를 통해 해당 디렉토리의 프로젝트를 켠다.


    4. 자바 에디터 속 **Main_All_test.java** 파일을 통해 어플리케이션을 실행시킨다.


        - (1-1) 이때, LectureLost.csv 파일의 코드상 경로들이 상대 경로로 설정되어 있어서 src 폴더의 바로 밖에 LectureLost.csv 파일이 위치한다면 대부분의 경우 올바르게 실행될 것이다.


        - (1-2) 혹시라도 제대로 실행되지 않는다면, LectureLost.csv 파일에 대한 절대 경로를 LectureLost.csv의 상대 경로로 지정되어 있는 부분에 붙여넣어 실행하면 된다.


        - (2-1) 시작 버튼이 눌려졌을 때, 제대로 웹캠이 실행되기 위해서는 파이썬 가상 환경의 폴더 경로와 eye_tracker.py 의 경로를 작성하는 것이 필요하다.
        

        - (2-2) ActivatePy.class에서의 가상 환경 및 python 파일 경로 설정이 필요하다. 우선 ActivatePy.class의 10번째 줄 virtualPath의 값에 (eye_tracker.py를 실행할 가상 환경 폴더의 경로)/python.exe를 입력한다. 그 다음 11번째 줄 new ProcessBuilder()에 다운로드 받은 eye_tracker.py의 경로를 입력해주면 된다.

    





<br>

## 4. 역할 분담 (이건 각자 자기가 담당한 내용에 대해서 작성하면 될 것 같습니다.)

### 🍊이세원

- **UI**
    - 
- **기능**
    - 

<br>
    
### 👻김주연

- **UI**
    - 화면 : 시작 화면
- **기능**
    - 시작 : 사용자에게서 필요한 데이터를 받아 저장, 타이머 바와 타이머 기능 구현, Java에서 python 파일 호출하여 실행 가능하도록 설정
    - 데이터 : 사용자에게 얻은 데이터와 csv 파일에서 읽은 데이터를 취합하여 조건에 맞게 새로운 csv 파일에 저장

<br>

### 🌠송하은
- **README.md** 
    - 대부분의 내용을 작성 완료함.
- **UI**
    - 화면 : 보고서 화면 (강의 당 각각의 패널 생성)
- **기능**
    - 보고서 : 보고서 재구성 기능, 강의 Bar 생성 기능, 강의 속 복습 구간 추천 기능, 강의 중 집중력 손실 구간 표시 기능
    - 데이터 : csv 파일 형식을 지정하여 데이터를 활용할 수 있도록 기획하였음. 

<br>

### 🐬이승채

- **UI**
    - 
- **기능**
    - 
    




<br>

## 5. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2024-05-15 ~ 2024-06-19
- UI 구현 : 2024-06-14 ~ 2024-06-20
- 기능 구현 : 2024-06-14 ~ 2024-06-20


<br>

### 작업 관리
- 시험이 끝나자마자 거의 매일매일 회의를 진행하며, 기능에 대해 이해의 간극을 줄이고 개발을 착수하려고 노력하였습니다.

- 프론트엔드에서는 csv 파일에 대한 관리와 해당 데이터를 어떻게 받아와서 저장하고 가공할지에 대한 개별적인 비대면 회의나 카톡 대화를 진행하였습니다.

- 프론트엔드에서는 각자 구현한 화면을 공유하기 위해서 각자의 브랜치에 수정 사항을 업로드하고, 카톡으로 알려주면 파일을 바꾸는 것으로 서로 간의 화면 동기화를 계속해서 진행하였습니다.

- 벡엔드에서는 ~~~ 





<br>

## 6. 페이지별 기능
### [초기화면]
- 내가 집중도를 측정하고 싶은 강의에 대한 이름과 해당 강의의 실제 시간을 작성할 수 있도록 하였고, 확인 버튼을 누르면 데이터가 csv 파일로 저장될 수 있도록 처리해두었습니다.


- 시작 버튼을 누르면, 동공 트래킹에 대한 웹캠이 뜨면서 아래 타이머가 돌아가게 됩니다.
    - 실제 강의 시간과 별개로, 자신이 해당 강의를 얼마나 봤는지 확인할 수 있도록 움직이는 타이머 Bar와 타이머 라벨이 뜨도록 하였습니다.

- 종료 버튼을 누르면, 종료 시간과 함께 동공 트래킹의 결과(집중력을 잃은 당시 현재 시간과 집중력을 회복한 당시 현재 시간), 강의명, 강의 시간 등이 보고서에 활용될 수 있도록 가공되어 lectureLost.csv 파일에 저장됩니다.


| 초기화면 1 |
|----------|
![시작화면_1](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/96b65dc2-0ad0-420b-8c78-957780142c41)

- 시작 화면입니다.

<br>

| 초기화면 2 |
|----------|
![시작화면_2](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/36f689ee-ec35-463f-bc89-b538dfb1d1ff)

- 강의명과 강의 시간을 입력한 후 '시작' 버튼을 눌렀을 때의 화면입니다. 하단에 입력한 강의 시간을 기준으로 흐른 시간의 비율을 보여주는 타이머 바와 흐른 시간을 (시):(분):(초) 형식으로 알려주는 타이머가 생성됩니다.


<br>

### [보고서 화면]
- LectureLost.csv 파일에 저장되어 있는 강의 데이터들을 아래의 형식으로 나타냅니다.
    - 집중하지 못한 시간 :  사용자가 실제로 시작 버튼을 누르고 종료 버튼을 누르는 시간 동안 집중력을 잃었던 시간을 그 간격과 함께 나타내 줬습니다.
    - 실제 강의 시간 : 사용자에게 받은 자신이 듣고 싶은 사이버 강의의 시간을 입력 받았기에 해당 내용을 표시할 수 있도록 했습니다.
    - 실제 강의에서 다시 복습해야할 부분 : 사용자가 강의를 끊지 않고 계속 틀어놨다고 가정하였을 경우, 실제 강의 시간을 기준으로 해당 시간 동안 집중력을 잃은 시점을 가공하여 보여줬다. 이를 통해 사용자가 자신이 어떤 부분에 있어서 집중력을 잃었는지 강의를 보면서 새로 복습을 진행할 수 있도록 했습니다.
    - 색깔 Bar : 실제 강의 시간은 민트색으로, 시작 - 종료 버튼을 누른 시간 간격은 베이지색으로, 집중력을 잃은 부분은 빨간색으로 표현하였다. 이를 통해 사용자가 빠르게 자신이 집중력이 잃었던 시간을 파악할 수 있습니다.

- 각 강의마다 데이터가 다르기 때문에 정보가 다 다르게 표시됩니다. 스크롤 기능도 있어서 많은 데이터를 한 화면에서 확인할 수 있습니다.
- 파일 정보가 바뀔 때마다 '집중도 측정' 탭에서 다시 '집중도 보고서' 탭으로 들어오면, 방금 저장된 강의 집중도도 보고서 형식으로 생성되도록 구현하였습니다.

| 보고서 화면 |
|----------|
![보고서화면](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/83f27b3d-fe4a-4a4b-a329-3d845648291d)




<br>

### [웹캠 화면 : 기본]
- 이메일 주소와 비밀번호를 입력하면 입력창에서 바로 유효성 검사가 진행되고 통과하지 못한 경우 각 경고 문구가 입력창 하단에 표시됩니다.
- 이메일 주소의 형식이 유효하지 않거나 이미 가입된 이메일일 경우 또는 비밀번호가 6자 미만일 경우에는 각 입력창 하단에 경구 문구가 나타납니다.
- 작성이 완료된 후, 유효성 검사가 통과된 경우 다음 버튼이 활성화되며, 버튼을 클릭하면 프로필 설정 화면이 나타납니다.

| 웹캡 화면 |
|----------|
![보고서화면](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/83f27b3d-fe4a-4a4b-a329-3d845648291d)


<br>

### [녹화 화면 : 경고]
- 이메일 주소와 비밀번호를 입력하면 입력창에서 바로 유효성 검사가 진행되고 통과하지 못한 경우 각 경고 문구가 입력창 하단에 표시됩니다.
- 이메일 주소의 형식이 유효하지 않거나 이미 가입된 이메일일 경우 또는 비밀번호가 6자 미만일 경우에는 각 입력창 하단에 경구 문구가 나타납니다.
- 작성이 완료된 후, 유효성 검사가 통과된 경우 다음 버튼이 활성화되며, 버튼을 클릭하면 프로필 설정 화면이 나타납니다.

| 웹캠 경고 화면 |
|----------|
![보고서화면](https://github.com/dl-tpdnjs/OS_Final_Prj/assets/155309085/83f27b3d-fe4a-4a4b-a329-3d845648291d)


<br>

## 7. 오픈소스 코드 설명(벡엔드분들 여기에 자신이 코드를 어떻게 수정했는지 너무 길게는 아니고 좀 간단하게 작성해보셔요)
### 활용한 오픈소스 링크
- https://github.com/Shayan925/ADHD-Aid
    - 어떤 점을 수정했는지 작성해주시면 될 것 같습니다!!






<br>

## 8. 프로젝트 수행 결과의 한계점(일단 프론트 내용은 작성이 끝났으니, 최종 보고서에 있는 개발 기술의 한계점을 작성하고 붙여넣으면 됩니다.)
- 프론트엔드
    - ‘시작’ 버튼 클릭 시 타이머 시작과 함께 eye_tracker.py를 실행하도록 설정하였는데, 실행하여 보니 eye_tracker.py를 호출하고 실행창이 뜨기까지 걸리는 시간이 예상했던 것보다 조금 더 걸리는 것을 확인할 수 있었다. 이 때문에 프로그램을 실행하는 컴퓨터의 상태에 따라 강의 초반 몇 초 동안은 사용자의 집중도 측정이 어려울 수 있다. → 하지만 해당 문제는 사용자가 사이버 강의를 틀자마자 집중력을 잃을 것이라고 생각하지 않는다면, 크게 문제가 되지 않을 수 있다.
    - 사용자가 강의 집중도를 측정하기 위해서는 우선 Java 프로그램을 실행하고, 강의명과 강의 시간을 입력한 후 강의 시작과 함께 프로그램의 '시작' 버튼을 눌러야 한다. 만약 강의가 실시간 강의가 아닌 녹화 강의인 경우에는 사용자가 강의 동영상의 시작 버튼과 프로그램의 '시작' 버튼을 각각 클릭해야 하므로 사용자 입장에서는 이 점이 조금 번거롭게 느껴질 수 있다.
    - 집중을 잃었을 시 타이머가 멈추는 기능이 따로 구현되지 않았다.
    - 사용자에게 해당 정보를 측정하기 위해서는 앱 사용 조건을 꼭 지켜서 사용해야 한다는 한계점이 있다. 예를들어서 시작 버튼이나 종료 버튼을 누르는 과정을 사용자가 신경 써서 사용해야 한다는 점이다. 시작 버튼을 강의를 시작하고 바로 누르지 않으면 실제 강의에 대한 복습 시점이 딜레이 될 수 있고, 종료 버튼을 강의 시간보다 매우 오래 동안 누르지 않으면 보고서 화면에서 작성될 Bar에 베이지 색이 너무 많아져서 실제 자신이 강의 시간에 언제 집중력을 잃었는지 파악하는데에 어려움을 겪게 될 수 있다.
    - 복습해야 할 시점은 오차가 생길 수 있다는 문제가 있다. 이는 실제로 강의를 모니터링하면서 복습해야 할 시점을 말해주는 것이 아니라 집중력을 잃은 시간에서 여러 수학적인 처리를 통해서 해당 위치에 약 15초 정도의 오차를 가지고 말해주기 때문에 발생하는 문제이다. → 하지만 이러한 문제는 사용자가 복습해야할 부분의 범위만 언급해주면 주체적으로 개념에 대해 앞 뒤로 보면서 파악할 것이라고 생각한다면 큰 문제가 생기지 않을 수 있을 것이다.

    
<br>

## 9. 프로젝트 중 어려웠던 점 및 느낀 점 (여기는 최종 보고서에 작성한 '프로젝트 수행의 어려움 및 느낀점'을 붙여넣어 주시면 됩니다.)

### 🍊 이세원

- 

<br>

### 👻 김주연

- Java 프로그램에서 python 파일을 실행할 수 있도록 연결하는 것을 구현하는 과정이 어려운 부분이었다. ProcessBuilder 클래스에 대해 알아보고, 해당 클래스를 사용하여 python 파일을 실행하는 메서드를 만들어 실행하였으나 처음에는 python 파일이 제대로 실행되지 않았다. 
    - 이후 google 검색을 통해 ProcessBuilder 클래스를 이용하여 가상 환경에서 python 파일을 실행하는 것도 가능하다는 것을 알게 되었고, python 파일이 제대로 실행되는 가상 환경의 경로를 ProcessBuilder에 넣어 성공적으로 python 파일을 실행할 수 있었다. 
    - 해당 과정을 통해 Java에서 외부 프로그램 파일을 호출하는 방법을 알게 되었으며, 추후 Java 프로그램 제작 시 기존 Java만 사용하여 제작하던 때보다 더 확장성 있는 프로그램 구현이 가능하겠다는 생각이 들었다.


<br>

### 🌠 송하은

- 사용자가 어플리케이션을 사용할 때 동영상을 멈춘다고 가정할 것인가 또는 사용자가 종료 버튼을 누르는 것을 까먹게 되어 실제 강의가 종료된 시간보다 오랜 시간 동안 기록이 되었을 경우에 보고서 내용이 이상하게 작성되는 문제가 발생할 위험성이 있을 수 있었다. 
    - 즉, 사용자의 조건을 어떻게 설정할 것인지에 따라서 데이터를 어떻게 가공하여 사용자에게 더 나은 서비스를 제공할까에 대한 고민이 생겼다. 예를들어 사용자가 사이버 강의를 들으면서 주의 집중을 하지 않아 복습이 필요한 부분에 대해 말해주려고 할 때, 사용자의 조건이 어느정도 정해져 있지 않으면, 사용자 특화된 강의 복습 시간을 제대로 정해줄 수 없을 가능성이 있다는 점이 있어 계속 가정을 바꿔 나가면서 최적의 조건은 무엇인지 선택을 하느라 오래걸렸다고 말하고 싶다. 
    - 이러한 문제를 해결하기 위해서 사용자가 시작 버튼을 누르는 동안 강의를 끄지 않고 들었다는 전제하에, 사용자가 어디서 집중력을 잃었고 다시 집중하기 시작했는지를 파악할 수 있도록 하는 것이 수치적으로 나타내는 것에 좋을 것 같다고 판단했다. 
    - 해당 조건을 가지고 시각적으로 요약해서 표현할 정보나 그래프를 보고서 형식으로 사용자에게 도움이 되도록 제공할 수 있다는 점에 의의를 둘 수 있었고, 스스로 해당 내용을 구현했음에 뿌듯함을 느낄 수 있었다고 생각한다.


- 버튼을 누르고 끄는 동안에 사용자의 눈동자 움직임을 파악하는 동공 트래커를 통해서 log.csv에 대한 데이터를 사용자를 위한 보고서로 작성할 때, 실제 강의에 대해서 동공 트래커 로그가 작성되는 것이 아니라 강의 시간과 독립적으로 사용자의 주의 집중도를 파악할 수 있다는 점도 문제가 되었다. 
    - 게다가 로그가 현재 시간(ex. 18:23:33) 형식으로 기록되기 때문에, 00:00:00부터 시작하는 실제 강의 시간에 언제 사용자가 주의 집중을 잃었는지 한눈에 파악하기가 힘들다는 점에서 고민을 많이 했다고 생각한다. 
    - 이러한 점을 극복하기 위해서 TimerPanel3.java파일에서 button_start, button_end, lost_start, lost_end, lecture_time 등의 정보를 수학적으로 셈하면서 사용자가 복습이 도움이 될 수 있도록 재가공하여, 시각적으로 집중한 비율을 표현하는 Bar나 복습했을 때 좋은 시간대를 실제 강의 시간에 맞도록 제공할 수 있었다. 
    - 물론 약간의 오차가 약 15초 정도 차이가 날 수 있지만, 어떠한 개념을 학습하는데 범위만 제공해주면 사용자가 원하는 시간대의 내용을 앞 뒤로 돌아가며 학습하는데 기여할 수 있을 것이라고 생각했다. 이러한 점을 보았을 때 사용자 친화적으로 앱을 구상하는데 고민을 많이 해본 것 같아서 한층 성장한 기분이 들었다.


<br>

### 🐬 이승채

- 




<br>

## 10. 프로젝트 후기 (이건 새로 작성해주세요! 최종 보고서에 없는 내용이에요! 가볍게 그냥 후기 남기면 좋을 것 같아요)

### 🦈 이세원



<br>

### 👻 김주연



<br>

### 🌠 송하은


팀 프로젝트를 진행하면서 이렇게 좋은 팀원들과 함께 프로젝트를 진행할 수 있어서 정말 행복했습니다. 모든 팀원이 자신의 할 일을 빠르게 해결하고, 혹시 잘 안 풀리는 문제가 있으면 함께 고민하여 빠른 해결이 가능했다는 점에서 팀 프로젝트가 두렵게 느껴지지 않았던 것 같습니다. 😍
처음에는 어떻게 구현해야 할지 막막했고, 아는 언어가 java, python, c언어밖에 없어서 내가 정말 완성된 서비스를 제작할 수있을까라는 두려움이있었지만, 차근차근히 하다 보니 프로그램을 작성하는 루틴이 생겼고 저만의 방식을 익혀나갈 수 있었던 것 같아서 성장할 수 있었던 시간이었습니다.

오픈소스를 이용해서 어떤 서비스를 제작해 보는 건 이번이 2번째입니다. 항상 다른 사람의 소스를 볼 때마다 느끼는 거지만 사람마다 너무 다양한 방식으로 코드를 구성하고 있기 때문에 ,그 코드의 구성을 파악하는 것에도 시간이 오래 걸리 개량하는 데에도 시간이 만만치 않게 걸리는 것 같아 이번에 벡엔드 팀도 정말 고생했을 것이라는 생각이 드네요.

한 학기 동안 오픈소스프로그래밍이라는 수업을 들으면서 배웠던 깃허브로 협업하는 방법, 아나콘다 이용 방법이 어디서든 활용이되더라고요. 이렇게 실용적으로 도움이 되는 강의를 일찍 2학년 1학기에 들을 수 있었다는 것이 좋았습니다. 또 오픈소스에 대한 정확한 정보를 들을 수 있어서 앞으로 개발하는 데 있어서서 라이선스나 저작권을 지키는 모범개발자💙가 될 수 있도록 앞으로도 노력하겠습니다.

<br>

### 🐬 이승채



<br>




## 11. 라이선스 표기 📝

This project is [MIT](https://github.com/dl-tpdnjs/OS_Final_Prj/blob/main/LICENSE.txt) licensed.




<br>




## 12. 프로젝트 팀원 깃허브 링크

- [이세원/dl-tpdnjs](https://github.com/dl-tpdnjs).<br />

- [김주연/kimkimikk](https://github.com/kimkimikk).<br />

- [송하은/EunHaSong](https://github.com/EunHaSong).<br />

- [이승채/chootkuri](https://github.com/chootkuri).<br />


---
