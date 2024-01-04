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
<summary>pom.xml_content</summary>

```
<build>
...(중략)...

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

### 실습
#### 1. HelloWorld-REST-API Applicaton 용 img 생성하기
docker 를 사용하는 프로젝트에서 mvn 을 설치하면 특정 프로젝트에 대한 docker 이미지를 구축하는 걸 목적으로 하게 된다.

> mvn clean install   
* [mvn 설치방법](https://github.com/ormazed/ormazed.github.io/blob/main/work/info/install_tip.md)   
	    * mvn 이랑 nvm 이랑 착각해서 ㅋㅋㅋㅋㅋ
  
-------------------------------------------------------------------------------------------
###### 에러1-1   

```
[ERROR] The goal you specified requires a project to execute but there is no POM in this directory (/engn001/k8s/app/app). Please verify you invoked Maven from the correct directory. -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MissingProjectException

```
> 해결1 :   
> pom.xml 파일을 찾지 못해서 발생하는 현상이었다.   
> 명령어를 실행할 때 pom.xml 파일이 있는 경로에서 명령어를 실행하면 된다.   

###### 에러1-2   

```
[ERROR] COMPILATION ERROR :
[INFO] -------------------------------------------------------------
[ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
[INFO] 1 error
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  09:23 min
[INFO] Finished at: 2024-01-05T00:11:18+09:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project 01-hello-world-rest-api: Compilation failure
[ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
[ERROR]
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
> 해결2 :   
> 설치한 Virtual Machin 에서 기본 제공하고 있던 java 가 jdk 가 아니라 jre 였다.
> 위 기능을 사용하기 위해서는 jdk 설치가 필요하다.
> yum 으로 적절한 jdk 를 설치한 다음 환경변수를 적절히 변경해주면 해소가 가능해진다.
> `docker image ls` 명령어를 사용하여 maven 으로 build 한 jar 파일의 이미지를 확인할 수 있다.


###### 추가  
> 강의에서는 맥북을 쓰는 지 그냥 경로에다가 docker 랑 mvn 명령어를 사용하는 게 보였는데,   
> 나 같은 경우에 sts 는 windows local PC 에서 돌리고 Docker 는 VMWare Linux 랑 GCP Linux를 사용해서 돌리고 있었던 지라.   
> sts 를 위한 Windows 환경을 Local PC 에다가 새로 구성해야하나 고민하다가 걍 파일을 VMWare Linux 환경에다가 업로드해서 시도해봤는데 딱히 별문제 없이 잘 되는 것 같다.   
-------------------------------------------------------------------------------------------
#### 2. 생성한 Docker image 를 Docker Hub 에 upload
* Docker Hub 명령어
```
docker login -u "자신의 DOCKER_HUB USER"
docker push "자신의 DOCKER_HUB USER"/hello-world-rest-api:0.0.4-SNAPSHOT
```
> 참고 : docker Hub 계정과 관련하여서 접속이 되지 않으면 `docs`(https://docs.docker.com/go/access-tokens/) 를 참고하면 된다.

###### 에러2-1   
: docker img 를 push 하는 명령어를 사용하였는데 error 가 발생했다.

> docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT

```
$ docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT
The push refers to repository [docker.io/ormazed/hello-world-rest-api]
An image does not exist locally with the tag: ormazed/hello-world-rest-api
```
: 알고보니까 pom.xml 의 <configuration>/<repository> 에 자신의 Docker Hub USER 로 변경해주는 작업이 필요!!!
: 변경 후 다시 이미지를 생성하면 된다.

* pom.xml : dockerfile-maven-plugin
```
<configuration>
   <repository>ormazed/${project.name}</repository> // 이미지/프로젝트명 ( 변경 전 in28min -> ormazed)
      <tag>${project.version}</tag> // 프로젝트 버전
      <skipDockerInfo>true</skipDockerInfo>
</configuration>
```
> docker clean install
> docker image ls
> docker push kandan7/hello-world-rest-api:0.0.4-SNAPSHOT


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