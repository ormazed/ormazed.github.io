# Tomcat 에서 Rewrite 설정 방법
## 방법1 Valve 를 이용한 방법
(1) server.xml 에 애라의 내용을 추가
```
<Valve className="org.apache.catalina.valves.rewrite.RewriteValve" />
```
(2) rewrite.config 파일 생성
CATALINA_PATH}/conf/Catalina/localhost 이하 경로에 rewrite.config 파일을 추가

(3) RewriteRule 작성
rewrite.config 에 RewriteRule 을 작성하면 된다.

@ 주의할 점.  
Tomcat Rewrite 작성 예시를 보았을 때 Apache Web 서버의 작성방법과 동일해서, 동일한 방식으로 동작한다고 생각하여 사례가 훨씬 자세한 Apache Web 서버의 rewrite docs 내용을 참고하여 작성했다.   

그런데 이상하게 작성을 하고 나면 Tomcat 기동 시 에러가 발생하길래 기동로그 내용을 확인해보니, `Caused by: java.lang.IllegalArgumentException: rewriteValve.invalidFlags` 라는 메세지가 보였다.   

알고보니 완전히 동일하지는 않고 서버변수나 Flag 등이 꽤나 차이가 있었다.    
tomcat rewrite docs 내용을 보면 docs 에서도 Apache HTTP Server 의 mod_rewrite 와 매우 유사하다고 했는데 당했다.   
=> 참고로 사용가능한 Flag 는 아래 경로에 작성된 Flag 에 한해서만 가능하다.  
(경로 : https://tomcat.apache.org/tomcat-9.0-doc/rewrite.html)

[예약어]
- RewriteRule
- RewriteCond
- RewriteMap
- 서버 변수

> 서버 변수 중 %{REQUEST_PATH} %{CONTEXT_PATH} %{SERVLET_PATH} %{THE_REQUEST} %{REQUEST_URI} %{REQUEST_FILENAME} %{HTTPS} 등은 Tomcat Valve 에 특화된 변수로 보인다.   


(다행히 주석은 `#` 으로 동일하다.)
(Perl 정규식 기반으로 RewriteCond 를 작성하면 된다.)




## 방법2. web.xml 방식

이것 때문에 한참 헤맸다.
(1) HTTP to HTTPS Redirect 설정이 추가되어 있어야한다.

(2) web.xml에 추가
```
<security-constraint>
  <web-resource-collection>
    <web-resource-name>restricted method</web-resource-name>
    <url-pattern>/*</url-pattern>
  </web-resource-collection>
  <auth-constraint/>
</security-constraint>
```

HTTPS Connector 에 반드시 redirectPort 가 선언되어 있어야한다.


WAS 에 SSL 설정방법

---
server.xml
```
<!-- HTTP Connector -->
<Connector UIEncoding="UTF-8" bindOnInit="false" ...()... port="8080" protocol="HTTP/1.1" redirectPort="8443" connectionTimeout="20000" />

<!-- HTTPS Connector -->
<Connector SSLEnabled="true" URIEncoding="UTF-8" ...()... port="8443" redirectPort="8443" protocol="org.apache.coyote.http11.Http11NioProtocol">
  <SSLHostConfig>

    <Certificate certificateKeystoreFile="ssl/keystore" certificateKeystorePassword="admin1234" type="RSA"/>
  </SSLHostConfig>
</Connector>
```
