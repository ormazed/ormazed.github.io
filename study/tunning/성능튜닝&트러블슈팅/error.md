# CH03
## Window 서버에 JAVA 버전이 다수일 때

: 윈도우 서버에 자바 버젼이 여러개인데 환경변수를 변경하려고 용을 썼는데도 이상하게 변경한 값들이 제대로 반영이 안되서, 때려치우려다가 얼떨결에 얻어 걸렸다.   
: 어느 분이신지 모르지만 격하게 사랑합니다.   
(SOL)
출처 : https://ichi.pro/ko/windowseseo-yeoleo-jdk-java-gan-e-jeonhwanhaneun-bangbeob-188808991195692


---

(CASE1)
```
 'C:\Program'은(는) 내부 또는 외부 명령, 실행할 수 있는 프로그램, 또는 배치 파일이 아닙니다. 라는 메세지와 함께 실행이 되지 않는다.

PC에 자바가 여러개 설치되어 있어서 ./startup.bat을 하니까 자꾸 JDK17을 받아와서 startup.bat 에다가 자바 경로를 직접 입력하고 실행하니까 자꾸 저런 메세지가 확인되었다.
-> 자바 경로에 띄워쓰기가 들어가서 그렇다고 한다.
-> 입력한 자바 경로 앞뒤로 "" 를 묶어주면 된다.
"C:\Program Files\Java\jdk1.8.0_202\bin\java" -Xmx1024m -classpath ./scouter-server-boot.jar scouter.boot.Boot ./lib
```

(CASE2)
아 내가 미쳐... 강의에서 ./start-jmeter.bat 쓰길래 나도 그거 한 번 써보려고 아둥바둥했건만..
```
C:\utils\scouter\scouter\demo-env1>"C:\Program Files\Java\jdk1.8.0_202\bin\java" -cp jmeter\bin\jmeter.bat -n -t jmeter\bin\scouter-demo1.jmx
Unrecognized option: -n
Error: Could not create the Java Virtual Machine.
Error: A fatal exception has occurred. Program will exit.
```

도대체 윈도우 자바 환경변수 변경은 어케하누.. 환경변수를 아무리 바꿔도 환경변수 설정 란에서는 JDK11이보이고 CMD 에서 JAVA --VERSION 하면 JDKL17 이 잡히고, 이런거 하나 돌리면 기본이 JDK17 이고..
나는 JDK1.8 을 기본으로 설정하고 싶고.   
이클립스 쓸거 생각하면 VM Ware Linux 버전도 함부러 못쓰겠고 미쳐버리겠네   
와...
 
