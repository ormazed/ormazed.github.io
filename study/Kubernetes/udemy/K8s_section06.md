# Section06. MySQL - 웹 어플리케이션으로 K8S & Docker 

## Step01. MySQL 코드 검토
---

H2 Database 같은 경우 인 메모리 방식의 데이터베이스이기 때문에 어플리케이션이 중지되면 내부의 데이터도 함께 없어진다.

```
spring.jpa.hibernate.ddl-auto=update
```

## Step02. MySQL 을 로컬환경에서 도커 컨테이너로 활용하기
---

`docker run mysql:5.7`

```
You neet to specify one of the following as an environment variable:
- MYSQL_ROOT_PASSSWORD
- MYSQL_ALLOW_EMPTY_PASSWORD
- MYSQL_RANDOM_ROOT_PASSWORD
```

`docker run -e `

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name=mysql --publish 3306:3306 mysql:5.7

이전 강의에서는 내장 DB 를 사용하였기 때문에 Application 이 중지되면 내장된 데이터도 같이 사라지지만,
mysql DB 를 별도로 사용하게 될 경우, DB Server 에서 정보를 관리하기 때문에 Application 의 동작과 독립하여 정보가 보관된다.

----------------------------------------------------------

(추가)
나 같은 경우 vmware 에 설치한 Linux 에 Docker 를 설치하였기 때문에
Application 을 동작시키고 있는 서버(Windows) 와 DB 서버(Linux) 의 IP 가 상이한 상태였다.
그렇기 때문에 강의에서 나온 것처럼 그냥 `SpringBootFirstWebApplication.java` 파일을 Run 하게 될 경우
DB 관련 에러가 발생했다.

* applicaton.properties
```
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
logging.level.org.springframework.web=INFO

management.endpoints.web.base-path=/manage
management.endpoints.web.exposure.include=*
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://DB_IP:3306/todos?characterEncoding=UTF-8&useSSL=true&enabledTLSProtocols=TLSv1.2
spring.datasource.username=todos-user
spring.datasource.password=dummytodos
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
```

## Step03. 웹 어플리케이션 03의 도커이미지 생성 및 링크를 활용할 연결
---
```
cd /engn001/k8s/app/kubernetes-crash-course-master/03-todo-web-application-mysql
mvn clean install
docker run -p 8080:8080 --link=mysql -e RDS_HOSTNAME=mysql in28min/todo-web-application-mysql:0.0.1-SNAPSHOT
```

```
# docker run -p 8080:8080 in28min/todo-web-application-mysql:0.0.1-SNAPSHOT
         <-- mysql container 와 연결되어 있지 않기 때문에 error 발생
The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
        at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
        at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
        at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
        at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:61)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:105)
        at com.mysql.cj.exceptions.ExceptionFactory.createException(ExceptionFactory.java:151)
        at com.mysql.cj.exceptions.ExceptionFactory.createCommunicationsException(ExceptionFactory.java:167)
        at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:91)
        at com.mysql.cj.NativeSession.connect(NativeSession.java:150)
        at com.mysql.cj.jdbc.ConnectionImpl.connectOneTryOnly(ConnectionImpl.java:947)
        at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:817)
        ... 61 more
Caused by: java.net.ConnectException: Connection refused (Connection refused)
        at java.net.PlainSocketImpl.socketConnect(Native Method)
        at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:350)
        at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:206)
        at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:188)
        at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:392)
        at java.net.Socket.connect(Socket.java:589)
        at com.mysql.cj.protocol.StandardSocketFactory.connect(StandardSocketFactory.java:155)
        at com.mysql.cj.protocol.a.NativeSocketConnection.connect(NativeSocketConnection.java:65)
        ... 64 more
```


## Step04. 커스텀 네트워크에서 컨테이너 실행하기
---
```
docker network ls
docker network create web-application-mysql-network 
docker inspect web-application-mysql-network

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 mysql:5.7

docker run --detach --env MYSQL_ROOT_PASSWORD=dummypassword --env MYSQL_USER=todos-user --env MYSQL_PASSWORD=dummytodos --env MYSQL_DATABASE=todos --name mysql --publish 3306:3306 --network=web-application-mysql-network mysql:5.7
 
 docker inspect web-application-mysql-network
```

## Step05. Docker Compose 활용하기
---

쿠버네티스에 배포할 마이크로 서비스가 다수 존재할 경우 Docker Compose 를 사용하여 쿠버네티스 클러스터에 배포
```
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
vi docker-compose.yml
docker-compose up
```



## Step06. Kompose 활용하여 쿠버네티스 배치 설정 생성하기
---

`kompose란?`
: Docker Compose 를 Kubernetes Contaienr Orchestartors 로 변환해주는 Tool.

```
yum install epel-release
yum install -y kompose
```

참고
: CentOS7 에서 Kompose 설치방법
- https://docs.fedoraproject.org/en-US/epel/
- https://kompose.io/installation/#centos


## Step07. MySQL 및 자바 웹 어플리케이션용 쿠버네티스 YAML 검토
---

mysql 은 Kubernetes 사용 시 PV/PVC 를 필요로 한다.
-> 모든 MySQL 데이터를 저장하기 위한 저장소가 필요하기 때문

mysql-deployment.yaml
```
args:
    - "--ignore-db-dir=lost+found" #CHANGE
```
: lost+found 파일이 영구저장소에 생성된다.
: mysql 은 initial 될 때 경로에 디렉터리가 있을 경우 에러를 발생시키기 때문에, --ignore-db-dir 옵션을 사용하여 DB 초기화 때 인식하지 못하도록 한다.

## Step08. MySQL DB 쿠버네티스 클러스터에 배치하기
---
PV 생성 
DB --PVC-- PV 로 연결
Application - DB 연결

```
The Deployment "mysql" is invalid:
* spec.selector: Required value
* spec.template.metadata.labels: Invalid value: map[string]string{"io.kompose.service":"mysql"}: `selector` does not match template `labels`
```
: 구버전 yaml 파일에 deployment.yaml 에 selector 가 없어서 발생하는 현상.

## Step09. 쿠버네티스를 이용한 영구 저장소 사용 - PV & PVC
---

`VOLUME`
: 쿠버네티스 클러스터에서 요청되는 모든 스토리지
: Volume 을 위해서는 PV 가 필요하다
: PV 는 외부 스토리지를 클러스터에 매핑하는 방식
: PVC 는 POD 가 PV 를 요청하는 방식

Volume == PV == PVC == POD

## Step10. 쿠버네티스로 설정 Maps 사용하기
---


## Step11. 쿠버네티스로 Secrets 사용하기
---


## Step12. MySQL DB 용으로 ClusterIP 쿠버네티스 서비스 생성하기
---



