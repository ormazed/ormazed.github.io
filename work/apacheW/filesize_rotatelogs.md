# Apache 로그를 File Size 로 Rotate 설정하는 법
## 
https://httpd.apache.org/docs/2.4/en/programs/rotatelogs.html

Apache docs 의 내용을 보고
rotatelogs httpd.conf 파일을 수정
<Virtaulㅗost *:80>
	DocumentRoot /var/www/html
	ServerName localhost
	CustomLog "|bin/rotatelogs /var/log/logfile %M"
    errorLog "|bin/rotatelogs /var/log/errorlog.%Y-%m-%d-%H"
</VirtualHost>
