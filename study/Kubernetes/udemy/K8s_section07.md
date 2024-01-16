# Section07. 자바 스프링 부트 마이크로서비스로 K8s & Docker
## Step01. 마이크로서비스 소개
---

: 단일 애플리케이션을 개발하는 스타일의 하나
: 작은 서비스의 형식으로 각각의 프로세스를 실행하고 서로 통신하는 방식
: 비즈니스 중심으로 구축되며 자동화된 배치를 통해 독립적으로 배포된다.
:이러한 서비스를 위한 중앙집중식 관리가 존재하고 다양한 프로그래밍 언어와 데이터 스토리지 기술이 사용된다

`마이크로서비스`란
- REST 에 의해 노출되는 서비스
- Cloud Enabled : 구조 변경에 용이
- Small Well Chosen Deployable Units : 작은 단위의 포로세스로 구성


## Step02. 마이크로서비스의 이점
---


## Step03. 마이크로서비스의 한계
---

01. Bounded Context : 처음 구성을 할 때 경계를 정하기가 어렵다,
02. Configuration Management : 구성관리의 어려움
03. Dynamci scale up/down : 
04. Visibility : Component 의 status 에 대한 가시성 확보가 어렵다.
05. Pack of Cards : 각 Component 간의 밀집성이 강하여 영향을 많이 받는다.

## Step04. CCS 및 CES 스프링 부트 마이크로 서비스 개괄 소개
---
- currency-exchange-basic 코드 내 Spring Boot 개념
`spring-boot-starter-parent`
`spring-boot-starter-data-jpa`
`spring-boot-starter-security`
`spring-boot-starter-security`
`spring-boot-starter-actuator`
`spring-boot-devtools`

## Step05. Docker image push 및 마이크로서비스용 K8s 설정 생성하기
---

- Kubernetes 개념
`minReadySeconds`
`resources\request`
`resources\limits`
`readinessProbe`
`livenessProbe`



## Step06. 스프링부트 마이크로서비스를 쿠버네티스 클러스터에 배치하기
---

## Step07.마이크로 서비스와 쿠버네티스 서비스 탐색
---


## Step08. 마이크로 서비스와 쿠버네티스 서비스 탐색 - DNS
---

쿠버네티스는 현재 동작중인 서비스만 인식할 수 있다.
새로운 쿠버네티스 서비스가 시작되면 자동으로 이 DNS 를 등록한다.

05-currency-conversion-microservice-basic
ㅇ deployment.yaml
```
env:
  - name: CURRENCY_EXCHANGE_URI
    value: http://currency-exchange
  - name: SPRING_PROFILES_ACTIVE
    value: kubernetes
```
ㅇ application-kubernetes.properties
```
CURRENCY_EXCHANGE_URI=http://currency-exchange
```
 k logs currency-conversion-5b9497f54d-ccgfx |grep -i currency_exchange_uri
2024-01-16 12:55:46.501  INFO [currency-conversion,,,] 1 --- [           main] i.m.c.u.e.EnvironmentConfigurationLogger : CURRENCY_EXCHANGE_URI - http://currency-exchange

서비스 디스커버리를 실행하는 방법
(1) 환경변수 주입
(2) DNS (쿠버네티스가 직접 제공)
애플리케이션 시작 시 작동 중인 모든 서비스가 환경 변수로 주입되고, 이러한 환경변수를 애플리케이션에 접근할 때 사용가능하다.

* Service Discovary 란
: 마이크로 서비스의 경우 원격으로 주어진 관련 서비스에 대한 IP 정보를 얻어오는 별도의 방법이 필요하다.
(Scale UP/DOWN 등으로 IP 정보 등이 고정적이지 않기 때문)
참고 : https://nice-engineer.tistory.com/entry/Kubernetes-Service-Discovery

## Step09. 쿠버네티스 마이크로 서비스 탐색, 집권화 설정, 데이터 로드 밸런싱
---

_조사하기_
(1) `Service Discovery`
(2) `LoadBalancing`
(3) `중앙 집중식 구성`

## Step10. 쿠버네티스 Ingress 활용하여 마이크로 서비스 접근 단순화 하기
---

하나의 로드밸런서로 모든 마이크로서비스의 요청을 처리하는 방법
-> `Ingress`
: Ingress 는 하나의 LB 로서 요청을 개별 마이크로서비스로 라우팅하고 로드를 분산할 수 있다.
ㅇ 참고 : https://kubernetes.io/docs/concepts/services-networking/ingress/

- 강의에서 주는 ingress.yaml 파일 수정한 부분이 좀 많아서 작성
```
[05-currency-conversion-microservice-basic]# diff ingress.yaml*
12d11
< (수정)         pathType: Prefix
14,17c13,14
< (수정)           service:
< (수정)             name: currency-exchange
< (수정)             port:
< (수정)               number: 8000
---
> (기존)          serviceName: currency-exchange
> (기존)          servicePort: 8000
19d15
< (수정)         pathType: Prefix
21,24c17,18
< (수정)          service:
< (수정)             name: currency-conversion
< (수정)             port:
< (수정)               number: 8100
---
> (기존)          serviceName: currency-conversion
> (기존)          servicePort: 8100
```


## Step11. Ingress 프론트앤드와 백앤드를 사용한 구글 클라우드 LoadBalancer 검토하기
---

Ingress 가 할당받은 IP 로 Context 에 따른 분기가 가능해진다.





한 번에 되는 걸 보지를 못하지...ingress.yaml 로 Ingress 를 생성하고 나서 GKE 의 Ingress 란을 보니 아래와 같은 메세지가 떠있었다.
```
Translation failed: invalid ingress spec: failed to validate prefix path /currency-exchange/* due to invalid wildcard; failed to validate prefix path /currency-conversion/* due to invalid wildcard
```

ingress.yaml 의 path 가 "" 로 묶여야하나.. 싶어서 묶고 나니 또 이런 메세지가 확인된다.
```
Missing one or more resources. If resource creation takes longer than expected, you might have an invalid configuration.
```
ㅇ 참고 
: https://cloud.google.com/kubernetes-engine/docs/concepts/ingress?hl=ko#multiple_backend_services
: https://cloud.google.com/kubernetes-engine/docs/tutorials/http-balancer?hl=ko

