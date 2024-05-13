# Section05 자바 스프링부트 웹 어플리케이션으로 k8s & Docker 사용

## Step91
---

## Step02. 스프링부터 웹 어플리케이션을 돜커 허브로 도커 이미지 푸시하기
---

```
error: resource mapping not found for name: ...()... no matches for kind "Deployment" in version extensions/v1beta1
```

보고 있는 강의가 예전 강의라서 그런지 Deployment 의 apiVersion 이 사용하고 있는 쿠버네티스 버전에서 제공하는 것과 맞지 않은 현상이 확인되었다.
현재 사용하고 있는 쿠버네티스에서 제공하는, 리소스에 적합한 버전을 알고자 한다면 아래의 명령어를 사용하면 된다.

`kubectl api-resources`


`kubectl api-versions`
: Print the supported API version on the server, in the form of "group/version"


예제 코드에서 사용하고 있는 H2 DB 의 경우, 내장형 DB 이기 때문에  데이터 정합성에 문제가 발생할 수 있다.

## Step03
---



## Step04
---


