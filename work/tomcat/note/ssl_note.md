# Tomcat 에서 SSL 설정 방법
###### 아래의 글은 테스트나 조사에 의한 정보일 뿐, 정확한 정보라는 보장이 없습니다.
###### 참고용으로만 읽어주세요

Tomcat 의 server.xml 파일을 확인하면 HTTP/1.1 을 사용할 때 SSL 설정을 하는 Connector 구문이 두 가지 확인가능하다.

## 2. NIO 방식 vs ARP 방식
* `NIO Implementation` 방식
```
    <Connector port="8443" protocol="org.apache.coyote.http11.Http11NioProtocol"
               maxThreads="150" SSLEnabled="true"
               maxParameterCount="1000"
               >
        <SSLHostConfig>
            <Certificate certificateKeystoreFile="conf/localhost-rsa.jks"
                         type="RSA" />
        </SSLHostConfig>
    </Connector>
```   



* `APR/native implementation` 방식(HTTP/2 방식 기반)
```
    <Connector port="8443" protocol="org.apache.coyote.http11.Http11AprProtocol"
               maxThreads="150" SSLEnabled="true"
               maxParameterCount="1000"
               >
        <UpgradeProtocol className="org.apache.coyote.http2.Http2Protocol" />
        <SSLHostConfig>
            <Certificate certificateKeyFile="conf/localhost-rsa-key.pem"
                         certificateFile="conf/localhost-rsa-cert.pem"
                         certificateChainFile="conf/localhost-rsa-chain.pem"
                         type="RSA" />
        </SSLHostConfig>
    </Connector>
```   


## 2. JESS vs OpenSSL
Tomcat 에서 TLS 통신을 하는 방법은 크게 OpenSSL 을 사용하는 방식과 JESS 방식을 사용하는 방법 두 가지가 있다.
OpenSSL 방식을 사용하기 위해서는 Tomcat Server lib 경로 내에 ?.jar 파일이 존재해야 한다.