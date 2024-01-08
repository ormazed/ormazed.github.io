# Section03   
## step02 강의에서 발생한 error 기록   

#### 에러1-1   

```
[ERROR] The goal you specified requires a project to execute but there is no POM in this directory (/engn001/k8s/app/app). Please verify you invoked Maven from the correct directory. -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MissingProjectException

```
> 해결1-1 :   
> pom.xml 파일을 찾지 못해서 발생하는 현상이었다.   
> 명령어를 실행할 때 pom.xml 파일이 있는 경로에서 명령어를 실행하면 된다.   


---
### 에러1-2
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
> 해결 1-2 :   
> 설치한 Virtual Machin 에서 기본 제공하고 있던 java 가 jdk 가 아니라 jre 였다.   
> 위 기능을 사용하기 위해서는 jdk 설치가 필요하다.   
> yum 으로 적절한 jdk 를 설치한 다음 환경변수를 적절히 변경해주면 해소가 가능해진다.   
> `docker image ls` 명령어를 사용하여 maven 으로 build 한 jar 파일의 이미지를 확인할 수 있다.   

---
### 에러 2-1
: docker img 를 push 하는 명령어를 사용하였는데 error 가 발생했다.

> docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT

```
$ docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT
The push refers to repository [docker.io/ormazed/hello-world-rest-api]
An image does not exist locally with the tag: ormazed/hello-world-rest-api
```

> 해결2-2
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

### 에러2-2
: `docker push 이미지명`을 하니까 계속 멈춤 현상이 발생한다.

> docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT   

```
docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT
The push refers to repository [docker.io/ormazed/hello-world-rest-api]
bfbb07be1dd0: Pushing [===========>                                       ]  3.933MB/16.81MB
ceaf9e1ebef5: Layer already exists 
9b9b7f3d56a0: Layer already exists 
f1b5933fe4b5: Layer already exists 
```
> 시행착오   
(1) systemctl restart docker   
(2) docker hub 의 repository 명을 hello-world-rest-api 로 변경   
(3) 이미지 재빌드 : mvc clean install   
(4)

* 특이사항 : 재기동을 할 때마다 Pushing 에 찍히는 퍼센테이지가 달라진다.


> 해결책   
알고싶다 나도

하나 건졌다
vi /etc/docker/daemon.jar 인가 여기서 debug level 을 변경하고 systemctl status docker -l 을 하다가   
> level=error msg="Not continuing with push after error: context canceled"     
위와 같은 메세지를 찾았다. 검색하니까 나랑 동일한 현상인 케이스가 보인다.   
https://forums.docker.com/t/docker-push-to-docker-io-hub-hangs-as-waiting-with-no-error-or-timeout/9073/14   
journalctl -f -u docker.service   
해서 로그를 보는데, 별로 내용이 안 보인다.. 아까 error 뜨길래 또 뜰줄 알고 systemctl restart docker 도 했는데 흠..  

위의 경로에서 가보라는 대로 따라가서 내용을 참고해보니 docker proxy 관련 부분이 원인이라고 한다 흠..   
https://github.com/distribution/distribution/issues/2147   

https://docs.docker.com/config/daemon/systemd/   

아 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ   
안된다 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ   

https://github.com/distribution/distribution/issues/2147#issuecomment-273116755   
여기서 시키는 대로 
/etc/systemd/system/docker.service.d/http-proxy.conf 이것도 만들고 했는데 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ   


  
https://docs.docker.com/config/daemon/systemd/
https://docs.docker.com/config/daemon/#configure-the-docker-daemon
https://confluence.curvc.com/pages/viewpage.action?pageId=16450218
에이씨 안해

2024-01-08
에이씨 내가 뭘또해야돼
(1) 알약도 껐고 selinux 설정도 diabled 했고 firewalld 도 꺼봤고 --> 실패   
(2) 테스트하던 이미지 문제인가해서 다른 내용의 Dockerfile 로 생성한 이미지로 push 도 해봤고 --> 실패 : 기존 이미지 문제가 아니라, 뭔가가 있다.   
(3) 위에서 시키는 대로 proxy 어쩌구도 해봤고   
(4) 재기동은 시시때때로 하고   
(5) 버전문제인가 싶어서 1.24 에서 1.13ㄲ지 내려도 가보고   
 
뭐냐..;; 방금 전에 진짜 마지막이다라고 하면서 repository 부터 싹 다 새로 생성했는데, 여기서는 또 된다..?    
```
[root@ldy0803 docker]# diff Dockerfile*
1,4c1,3
< FROM wordpress:latest   <-- 됨
< RUN echo "good~"
< EXPOSE 80
<
---
> FROM ubuntu:latest <-- 안 됨.
> RUN apt update
> RUN apt install -y git
```

되는 건 또 왜 되고 안되는 건 진짜 왜 안되냐고... 사람 미쳐버리겠네   
일단 변화가 생겼으니 다시 간다.





---


