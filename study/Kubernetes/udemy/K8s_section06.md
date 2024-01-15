# Section06. MySQL - 웹 어플리케이션으로 K8S & Docker 

## Step01 MySQL 코드 검토
---

H2 Database 같은 경우 인 메모리 방식의 데이터베이스이기 때문에 어플리케이션이 중지되면 내부의 데이터도 함께 없어진다.

```
spring.jpa.hibernate.ddl-auto=update
```

## Step02
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
_applicaton.properties _
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

## Step0
---

## Step0
---


## Step0
---


## Step0
---


## Step0
---


## Step0
---


## Step0
---


## Step0
---


## Step0
---


## Step0
---



