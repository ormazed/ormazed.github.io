# Tomcat 에서 OpenSSL3 사용(작성중)

Tomcat Server 에서 사용 가능한 통신 방법은 HTTP 통신과 AJP 통신이 있다.   
HTTP 통신에서 사용가능한 protocol 로는 다음 세 가지가 존재한다.   
- NIO Connector (Tomcat6 부터 사용가능)   
- APR Connector (사용하기 위해서는 별도의 빌드가 필요하다)   
- NIO2 Connector (혹은 BIO Connector : tomcat 버전에 따라 사용가능한 Connector 가 달라진다.)   
** NIO2 : tomcat 8 / BIO : tomcat 7 이하
 

 현재 사용하고 있는 통신에서 참고하는 Connector 가 무엇인지 확인하기 위해서는 server.xml 내 <Connector> 를 확인하면 된다.   
-` BIO Connector` : <Connector protol="org,apache.coyote.http11.Http11Protocol>
- `APR Connector` : <Connector protol="org,apache.coyote.http11.Http11AprProtocol>
- `NIO Connector` : <Connector protol="org,apache.coyote.http11.Http11NioProtocol>

ㅇ 참고 : Connector Comparison 

---

## APR Connector
### 사용방법
`APR Library` / `libtcnative` / `OpenSSL library`

### 특징
위 세 조건이 갖춰진 상태에서 적절한 java 를 사용하고 있다면 톰캣은 기본적으로 APR 을 사용한다.   
다른 Connecctor 들과 대체로 비슷하지만 몇가지 추가 속성을 가지고 있다.   

ㅇ 참고  : native_specific_configuration 



ㅇ 참고
https://tomcat.apache.org/tomcat-8.5-doc/config/http.html#Java_TCP_socket_attributes
https://tomcat.apache.org/connectors-doc/
