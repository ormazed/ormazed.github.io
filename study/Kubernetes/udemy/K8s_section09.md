# Section09. 스프링부트  마이크로서비스 통합하기 - 구글 Stackdriver를 활용한 쿠버네티스
## Step01. 구글 Stackdriver 활용하기
---
마이크로서비스 방식을  사용하게 되면 문제 발생시 debugging 이 어렵다
-> 다른 기능을 사용하여 logging 및 debugging 을 용이하게 한다.

## Step02. 구글 Stackdriver 와 통합된 스프링부트  마이크로서비스 검토
---

- `Stackdriver`
로그를 살피고 여러 마이크로서비스에서 요청을 추적하는 등의 다양한 옵션을 제공

> 강의에서 stack driver 를 다루길래 강의를 따라 cluster 생성할 때 stack driver 를 설정하려고 한참 찾았는데 보이지 않았다.
> 알고 보니까 지금 내가 사용하고 있는 GKE Cluster 에서는 더 이상 stack driver 를 지원하고 있지 않는다.
> 참고 : https://cloud.google.com/kubernetes-engine/docs/how-to/config-logging-monitoring?hl=ko

|기존 설정	|기존 create 인수|기존 update 인수|새로운 create 및 update 인수
|---|---|---|---|
|사용 중지됨|--no-enable-stackdriver-kubernetes|--no-enable-stackdriver-kubernetes|--logging=NONE<br> --monitoring=NONE|
|시스템 모니터링만(로깅 사용 중지됨)|--enable-stackdriver-kubernetes<br> --no-enable-cloud-logging|--logging-service=none<br> --monitoring-service=monitoring.googleapis.com/kubernetes|--logging=NONE<br>--monitoring=SYSTEM|
|시스템 및 워크로드 로깅만(모니터링 사용 중지됨)|--enable-stackdriver-kubernetes<br>--no-enable-cloud-monitoring|--logging-service=logging.googleapis.com/kubernetes<br>--monitoring-service=none|--logging=SYSTEM,WORKLOAD<br>--monitoring=NONE|
|시스템/워크로드 로깅 및 모니터링|--enable-stackdriver-kubernetes|--enable-stackdriver-kubernetes|--logging=SYSTEM,WORKLOAD<br>--monitoring=SYSTEM|

** 강의가 어떻게 돌아가나 상황을 보고, 현재 버전에 맞춰서 조정하던가 아니면 구경만 하던가 결정해야겠다.

- 강의에서는 Stackdriver 를 다룬다고 하지만, 현재 버전에서는 Operations 라고 불리며, 일부 수정이 발생
  https://cloud.google.com/products/operations?hl=ko

(1) Google Cloud 콘솔의 탐색 패널에서 Kubernetes Engine을 선택한 후 클러스터를 선택 -> Kubernetes 클러스터로 이동
(2) Kubernetes Cluster 생성(만들기를 클릭)
(3) Standard 모드로 구성을 클릭(간편 모드에서는 생성 불가)
(4) 탐색창의 클러스터에서 기능을 클릭
(5) 작업 아래에서 수집하려는 로그 및 측정항목을 선택
-> 새 클러스터의 경우 Cloud Logging 및 Cloud Monitoring이 기본적으로 사용 설정됩니다.
-> 수집되는 로그를 변경하려면 Cloud Logging의 구성요소 메뉴를 클릭하고 로그를 수집하려는 구성요소를 선택합니다.
-> 수집되는 측정항목을 변경하려면 Cloud Monitoring의 구성요소 메뉴를 클릭하고 측정항목을 수집할 구성요소를 선택합니다.
-> Cloud Logging 통합을 사용 중지하려면(감사 로그 제외) Cloud Logging 사용 설정 체크박스를 선택 취소합니다.
-> Cloud Monitoring 통합을 사용 중지하려면 Cloud Monitoring 사용 설정 체크박스를 선택 취소합니다.
-> -> Google Cloud Managed Service for Prometheus를 사용 설정하려면 Google Cloud Managed Service for Prometheus 사용 설정 체크박스(1.21.4-gke.300 이상 필요)를 선택합니다. 이 체크박스는 구성이 필요한 관리되는 수집기를 사용 설정합니다.

07-currency-exchange-stackdriver\pom.xml 
아래와 같은 변경사항이 발생했다고 하는데, 아잇.. 이거 stackdriver 없는데 호환되려나..?
```
<dependency> <!-- CHANGE -->
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-gcp-starter-trace</artifactId>
</dependency>

<dependency> <!-- CHANGE -->
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-gcp-starter-logging</artifactId>
</dependency>
```

07-currency-exchange-stackdriver\application.properties
```
spring.sleuth.sampler.probability=1.0  <--PRD 환경에서는 비율이 훨씬 낮다(부하)
spring.cloud.gcp.trace.enabled=false <-- GCP 관련 내용은 Loggign 하지 않음 / Local 환경에서 활성화한다(deployment.yaml)
```
> deployment.yaml
>> spec\containers\env\name: SPRING_CLOUD_GCP_TRACE_ENABLED

## Step03. 구글 클라우드 계정에서 Stackdriver API 활성화하기
---


## Step04.
---


## Step05.
---


## Step05.
---

