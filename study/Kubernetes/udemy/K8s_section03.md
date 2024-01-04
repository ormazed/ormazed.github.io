# Section03 GKE-스프링 부트 Hello World REST API 로 쿠버네티스와 도커 사용하기
* 코드 출처 : https://github.com/in28minutes/kubernetes-crash-course
## Step 01 - 첫 3개 스프링 부트 프로젝트 Eclipse로 불러오기
## Step 02 - 로컬 환경에 스프링 부트 Hello World 기반 REST API 01 설치하기
* pom.xml 
```
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
		</dependency>

```   
> spring-boot-starter-web : Spring Boot 로 web/REST API 를 구축하기 위하여 사용   
> spring-boot-devtools : code 변경을 자동으로 인식하여 재기동하는 기능   

localhost:8080 을 호출하였을 때 확인되는 내용들은 HelloWorldController.java 에서 context 별로 분기된다.   
> @GetMapping(path='CONTEXT경로')   
---
## Step 03 - · Hello World 기반 Rest API용 도커 허브에서 도커 이미지와 푸시 기능 만들기   

Docker Container 내부나 Kubernetes 에서 앱을 실행하면 런타임 환경은 HOSTNAME 이라는 이름으로 환경변수를 주입한다.   
```
private static final String HOST_NAME = "HOSTNAME";
```
> (예시) 서비스가 어디서 실행 중인지를 HOSTNAME 으로 알아볼 수 있도록 함.

* pom.xml : dockerfile-maven-plugin
<details>
<summary>접기/펼치기</summary>

```
<build>
		<finalName>hello-world-rest-api</finalName>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<!-- Docker -->
			<plugin>
				<groupId>com.spotify</groupId>
				<artifactId>dockerfile-maven-plugin</artifactId>
				<version>1.4.6</version>
				<executions>
					<execution>
						<id>default</id>
						<goals>
							<goal>build</goal>
							<!-- <goal>push</goal> -->
						</goals>
					</execution>
				</executions>
				<configuration>
					<repository>in28min/${project.name}</repository>
					<tag>${project.version}</tag>
					<skipDockerInfo>true</skipDockerInfo>
				</configuration>
			</plugin>

		</plugins>

	</build>
```
</details>



---
## Step 04 - 구글 클라우드 설치하기
---
## Step 05 - Kubectl 설치하기
---
## Step 06 - 스프링 부트 Hello World 기반 REST API 01 쿠버네티스에 배치하기
---
## Step 07 - 배치 및 서비스를 위한 쿠버네티스 YAML 설정 생성하기
---
## Step 08 - 쿠버네티스 YAML 설정의 이해 및 개선
---
