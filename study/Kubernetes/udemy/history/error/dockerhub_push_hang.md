### docker push [이미지:태그]   
: `docker push 이미지명`을 하니까 계속 멈춤 현상이 발생한다.   
(현상)   
: docker push 명령어를 사용할 때마다 반복되고 있고 systemctl restart docker 를 해도 여전히 발생하고 있다.   
: 매번 다른 % 수준에서 hang 이 발생한다.   
> docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT   

```
docker push ormazed/hello-world-rest-api:0.0.4-SNAPSHOT
The push refers to repository [docker.io/ormazed/hello-world-rest-api]
bfbb07be1dd0: Pushing [===========>                                       ]  3.933MB/16.81MB
ceaf9e1ebef5: Layer already exists 
9b9b7f3d56a0: Layer already exists 
f1b5933fe4b5: Layer already exists 
```
---

> 해결책   
알고싶다 나도   

---

> 시행착오   
(1) systemctl restart docker   
(2) docker hub 의 repository 명을 hello-world -> hello-world-rest-api 로 변경/테스트할 때의 명과 동일하게 맞춤   
(3) 이미지 재빌드 : mvc clean install   

> 진행상항   
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
https://nevertrustbrutus.tistory.com/140   

```
[root@ldy0803 docker]# diff Dockerfile*
1,4c1,3
< FROM wordpress:latest   <-- 됨(ormazed/hubtest)
< RUN echo "good~"
< EXPOSE 80
<
---
> FROM ubuntu:latest <-- 안 됨(ormazed/hello-world-rest-api).
> RUN apt update
> RUN apt install -y git
```

되는 건 또 왜 되고 안되는 건 진짜 왜 안되냐고... 사람 미쳐버리겠네   
일단 변화가 생겼으니 다시 간다.

ormazed/hello-world-rest-api 를 다시 생성해서 push 테스트를 해봤는데도 여전히 안된다.
이쯤되면 docker 계정 문제나 통신 문제가 아니라 repository 애 이미지를 넣는 그 자체가 문제인 거 같은데
이걸 어디서부터 보면 좋을까
코드는 내가 작성한게 아니라 받아쓴거라서..

---
2024-01-09
어제 push 성공했다는 img 를 가지고 docker tag 명령어를 사용해서 hello-world-rest-api repository 에 업로드를 해봤는데
정상 업로드가 되는 것이 확인되었다.
이쯤되면 생성한 이미지가 문제인 게 분명해진다.
이야~ 드디어 해결했다
됐다는 이미지의 Dockerfile 을 가져와서 테스트에 사용중인 어플리케이션 소스에다가 넣어서 이미지를 말고 docker hub 에 업로드해보니까
잘~~~~올라간다.
기가막히네 아주 그냥

오... 테스트한다고 이것저것 docker hub 에 많이 올렸어서 docker push 한 이미지들을 제거하는 방법을 찾으니까
repository 제거 방법만 나오네.. 아주.. 빈대 없앤다고 초가삼간 다 태우네 그려..

---
2024-01-10   
아 열심히 작성하던거 노트북 배터리 나가서 날라갔다 승질나..   
요약하자면 docker log level 을 debug 로 낮췄는데도
별 내용이 없다는 것과 이 시도를 반복해왔는데 왜 이번에는 됐는지 잘 모르겠다는 것, 마냥 이미지 탓이라고 하기에는 그 이미지로 docker run 하면 기깔나게 잘 돌아가고 있다는 점이다.    
살려줘... 
