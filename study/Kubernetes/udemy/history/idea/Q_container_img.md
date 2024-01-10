##### 의문 : kubernetes deployment.yaml 의 image 는 어디서 가져오는 것인가
질문 : 왜 ormazed 가 아니라 in28min 이미지를 가져오는 거지

* 현 상태
(1) pom.xml 에 이미지를 생성할 때, 이름을 정하는 dockerfile-manve-plugin\configuration\repository 에 `<repository>oramzed/${project.name}</repository>` 라고 작성 => mvn clean install 하여 이미지를 만듦.  
(2) 지금 Docker Hub 에 이미지를 push 가 안되고 있는 상태   
(3) local 에 생성된 이미지는 oramzed/hello-world-rest-api 라는 이름으로 명명.   

이러한 상태에서 생성된 kubernetes pod 를 보니까 in28min/hello-world-rest-api 라고 명명되어 있었다.   
이 pod 의 이미지는 도대체 어디서 난 것인가하여 deployment.yaml 을 보니 containers\image 가 in28min/hello-world-rest-api 였다.   

```
다 좋다. 그렇다면 내 kubernetes container 는 이미지를 어디서 받아온 것인가...?`  
```

(sol)
바보 같이 image 의 작성법에 대한 기본적인 이해가 부족해서 생긴 문제였다.
deployment.yaml 에 image: in28min/hello-world-rest-api:0.0.2.RELEASE 라고 작성했다면.
내 ormazed docker hub 에 이미지가 없는 건 없는 거고 in28min 이라는 docker hub 계정으로 가서 뒤의 이미지 명과 버전에 해당하는 파일을 가져오는 거였다.
내가 이후 동영상 강의 테스트 못한다고 어떻게든 docker hub 에 이미지 올릴려고 아둥바둥한 거는 결국 무의미한 짓이었다는 의미다. 왜냐하면 강사의 되는 이미지를 받아오면 되거든!...에휴..


나는 이거보고 docker hub push 안되는 원인이 여기에 있나하고 좋아했는데..
