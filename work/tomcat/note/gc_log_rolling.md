# gc log filesize 별 log rolling 

__AS 를 중지하지 않고도 gc log 를 rolling 할 수 있는 방안에 대한 문의가 전달되었다.__
사실 마음으로는 gc log 가 덜 쌓이게 할 마음은 없냐고 묻고 싶었지만 사회적 도리상 입을 다물었다.   
요청된 내용은 일자나 월 단위로 log rolling 을 해달라는 내용이었지만, 아무리 찾아봐도 그건 좀;; 이라는 느낌이었다.   

좀 더 찾아보니 파일 사이즈 단위로 gc log rolling 하는 옵션은 눈에 띄였다.

```
set CATALINA_OPTS=%CATALINA_OPTS% -Xloggc:C:\path\to\gc.log
set CATALINA_OPTS=%CATALINA_OPTS% -XX:+UseGCLogFileRotation
set CATALINA_OPTS=%CATALINA_OPTS% -XX:GCLogFileSize
set CATALINA_OPTS=%CATALINA_OPTS% -XX:NumberOfGCLogFiles
```
테스트한 결과 -XX:+UseGCLogFileRotation 이 옵션만 넣고 다른 두 옵션을 빼먹으면 사람한테 꼽을 준다.   
> To enable GC log rotation, use -Xloggc:<filename> -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=<num_of_files>
> where num_of_file > 0
> GC log rotation is turned off

