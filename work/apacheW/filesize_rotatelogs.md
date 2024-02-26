# Apache 로그를 File Size 로 Rotate 설정하는 법
## 
https://httpd.apache.org/docs/2.4/en/programs/rotatelogs.html


### 테스트방법
Apache docs 의 내용을 보고
* rotatelogs httpd.conf 파일을 수정
```
<VirtalHost *:80>
	DocumentRoot /var/www/html
	ServerName localhost
	CustomLog "|bin/rotatelogs /var/log/access.log 1M" combined
    errorLog "|bin/rotatelogs /var/log/errorlog.%Y-%m-%d-%H 1M"
</VirtualHost>
```

- 위와 같이 작성한 뒤 Jemeter 로 Thread Group\HTTP Request 로 stress 를 전달하였다.  
- 테스트를 했는데도 Log Rolling 이 되지않고 하나의 파일에 계속 로그가 쌓이고 있는 현상이 보였다.   

* Jmeter 테스트 방법
(1) Test Plan => Add => Threads(Users) => Thread Group.  
(2) Number of Threads(users) : 100700 건 입력
> 작은 값을 넣고 Loop Count 를 늘려도 되긴 할 건데 귀찮아서 저렇게 넣었다(저렇게 넣으면 간당하게 1M 초과하게 되더라)
>> 왜냐하면 WEB 서버에서 생성되는 Thread 개수는 결국 정해져 있을 수 밖에 없을 테니까)

### 해결방법
https://superusr.com/questsions/868803/apache-rotatelogs-not-working-for-given-file-size

파일 사이즈가 차고나서 새로운 파일에다가 파일을 쌓으려고 할때
새로운 파일이 생성되어 있어야하는데, 1M 를 차는데는 수초가 안 걸렸는데 파일 생성명이 unique 하지 못해서
하나의 파일에다가 로그가 계속 적재되고 있어서 발생하는 현상이었다.

₩시간 로그롤링 != 파일생성 포맷₩

%M%S 등을 시간포맷을 더 자세하게 잡고나면 별 문제없이 잘 되는 것이 확인된다.
