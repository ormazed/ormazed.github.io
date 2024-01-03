#Section03 GKE-스프링 부트 Hello World REST API 로 쿠버네티스와 도커 사용하기
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


## Step 03 - · Hello World 기반 Rest API용 도커 허브에서 도커 이미지와 푸시 기능 만들기
## Step 04 - 구글 클라우드 설치하기
## Step 05 - Kubectl 설치하기
## Step 06 - 스프링 부트 Hello World 기반 REST API 01 쿠버네티스에 배치하기
## Step 07 - 배치 및 서비스를 위한 쿠버네티스 YAML 설정 생성하기
## Step 08 - 쿠버네티스 YAML 설정의 이해 및 개선
