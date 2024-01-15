# Section06 
## Step03 강의 수강 중 발생한 에러 및 대처방법

(문제1) application.properties 의 값을 수정하지 않았을 때 발생한 에러.
```
The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45) ~[na:na]
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499) ~[na:na]
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480) ~[na:na]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:61) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:105) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:151) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:167) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:91) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.NativeSession.connect(NativeSession.java:150) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:947) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:817) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	... 53 common frames omitted
Caused by: java.net.ConnectException: Connection refused: no further information
	at java.base/sun.nio.ch.Net.pollConnect(Native Method) ~[na:na]
	at java.base/sun.nio.ch.Net.pollConnectNow(Net.java:672) ~[na:na]
	at java.base/sun.nio.ch.NioSocketImpl.timedFinishConnect(NioSocketImpl.java:542) ~[na:na]
	at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:597) ~[na:na]
	at java.base/java.net.SocksSocketImpl.connect(SocksSocketImpl.java:327) ~[na:na]
	at java.base/java.net.Socket.connect(Socket.java:633) ~[na:na]
	at com.mysql.cj.protocol.StandardSocketFactory.connect(StandardSocketFactory.java:155) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:65) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	... 56 common frames omitted
```
(해결1) 아래 정보를 추가
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://DB_IP정보:3306/todos
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
```

---
(문제2)
```
The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45) ~[na:na]
	at java.base/java.lang.reflect.Constructor.newInstanceWithCaller(Constructor.java:499) ~[na:na]
	at java.base/java.lang.reflect.Constructor.newInstance(Constructor.java:480) ~[na:na]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:61) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:105) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:151) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:167) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeProtocol.negotiateSSLConnection(NativeProtocol.java:340) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeAuthenticationProvider.negotiateSSLConnection(NativeAuthenticationProvider.java:777) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeAuthenticationProvider.proceedHandshakeWithPluggableAuthentication(NativeAuthenticationProvider.java:486) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeAuthenticationProvider.connect(NativeAuthenticationProvider.java:202) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeProtocol.connect(NativeProtocol.java:1348) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.NativeSession.connect(NativeSession.java:163) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:947) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:817) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	... 53 common frames omitted
Caused by: javax.net.ssl.SSLHandshakeException: No appropriate protocol (protocol is disabled or cipher suites are inappropriate)
	at java.base/sun.security.ssl.HandshakeContext.<init>(HandshakeContext.java:172) ~[na:na]
	at java.base/sun.security.ssl.ClientHandshakeContext.<init>(ClientHandshakeContext.java:103) ~[na:na]
	at java.base/sun.security.ssl.TransportContext.kickstart(TransportContext.java:247) ~[na:na]
	at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:448) ~[na:na]
	at java.base/sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:426) ~[na:na]
	at com.mysql.cj.protocol.ExportControlled.performTlsHandshake(ExportControlled.java:316) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.StandardSocketFactory.performTlsHandshake(StandardSocketFactory.java:188) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeSocketConnection.performTlsHandshake(NativeSocketConnection.java:99) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	at com.mysql.cj.protocol.a.NativeProtocol.negotiateSSLConnection(NativeProtocol.java:331) ~[mysql-connector-java-8.0.17.jar:8.0.17]
	... 60 common frames omitted
```
(해결2) mysql 뒤에 `?characterEncoding=UTF-8&useSSL=true&enabledTLSProtocols=TLSv1.2`  추가
```
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://DB_IP:3306/todos?characterEncoding=UTF-8&useSSL=true&enabledTLSProtocols=TLSv1.2
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
```

---

## Stop06
```
FATA Version 3.7 of Docker Compose is not supported. Please use version 1, 2 or 3
>> 3.7 이 어디서 나왔지..?
>> 설치된 패키지들이랑 kompose 랑 호환성 때문에 안되는 거 같은데. 저 3.7 이 어디서 튀어나온 건지 도저희 모르겠다.

ㅇ 현재 사양
# docker --version
Docker version 24.0.7, build afdd53b

# kubectl version -o json
"v1.27.9-dispatcher"

# kompose version
1.7.0 (HEAD)

# docker-compose version
docker-compose version 1.23.2, build 1110ad01
docker-py version: 3.6.0
CPython version: 3.6.7
OpenSSL version: OpenSSL 1.1.0f  25 May 2017
```
