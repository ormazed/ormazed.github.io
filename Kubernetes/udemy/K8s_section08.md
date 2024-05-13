# Section08. 스프링부트 마이크로서비스와 자바 Sping 클라우드 K8s 통합하기

## Step01. 마이크로서비스로 Spring 클라우드 쿠버네티스 활용하기 
---

spring-cloud-starter-netflix-ribbon
spring-cloud-starter-kubernetes-all

06-currency-conversion-microservice-cloud\CurrencyExchangeServiceProxy.java
@RibbonCClient(name = "currency-exchange")
@FeignClient(name = "currency-exchange")

## Step02. Spring 클라우드 쿠버네티스 마이크로서비스 배치하기
---

```
Whitelabel Error Page
Error creating bean with name 'ribbonLoadBalancingHttpClient' defined in org.springframework.cloud.netflix.ribbon.apache.HttpClientRibbonConfiguartion
```

ribbonLB 는 쿠버네티스 서비스 디스커버리 시스템과 통신할 수 없어서 발생
-> 접근 권한을 갖는 서비스 계정이 필요하다.

## Step03. RBAC 를 활용하여 Ribbon 의 서비스 탐색 API 접근 허용하기
---

kubectl get serviceaccount
```
roleRef
  kindL ClusterRole
  name: view
  apiGroup: rbac.authorization.k8s.io
```

-> 어떤 원리에 의해서 CLusterRoleBinding 을 생성하고 나니 에러가 해소되는 지 모르겠다. 
이 부분에 대한 확인이 필요해보인다.
> 흠.. rbac.authorization.k8s.io 에 대한 권한이 default 계정에 원래 없는 건가..?


## Step04. ConfigMaps 로드를 위한 Spring 클라우드 쿠버네티스 설정하기
---

application.properties
: 스프링 클라우드 쿠버네티스는 어플리케이션 명으로 된 ConfigMap 을 생성하고 나면 스프링 클라우드 쿠버네티스는 api 를 통해 쿠버네티스와 통신이 가능해진다.
-> 컨피그맵 안의 정보를 가져와 애플리케이션이 시작할 때 로드가 가능해진다.

```
kubectl create configmap currency-conversion --from-literal=YOUR_PROPERTY=value \
--from-literal=YOUR_PROPERTY_2=value2
```
: currency-conversion pod 가 기동될때 컨피그맵의 정보를 가져간다.


## Step05. 쿠버네티스의 오토 스케일링
---

###### 오토스케일링 방법
(1) 노드 - 수평
(2) 파드 - 수평
(3) 자원증가 - 수직

###### Cluster Auto Scaling
```
gcloud container clusters ccreate example-cluster \
--zone us-centrall-a --node-locations us-centrall-a,us-centrall-b,us-centrall-f \
--num-nnodes 2 --enable-autoscaling --min-nodes 1 --max-nodes 4
```

###### Enable on Cluster
```
gcloud container clusters create CLUSTER_NAME --enable-vertical-pod-autoscaling --cluster-version=?
gcloud container clusters update CLUSTER-NAME --enable-vertical-pod-autoscaling
```
###### Configure VPA
```
kubectl get vpa currency-exchange-vpa --output yaml
```
참고 
: https://cloud.google.com/kubernetes-engine/docs/concepts/verticalpodautoscaler?hl=ko
: https://cloud.google.com/kubernetes-engine/docs/how-to/vertical-pod-autoscaling?hl=ko

## Step06. 쿠버네티스 수평 파드 오토 스케일링 수행
---

```
 k top 리소스명
```
k top pod / k top node 등 리소스가 사용하고 있는 CPU, 메모리양을 확인할 수 있다.

```
kubectl autoscale deployment currency-exchange --min=1 --max=3 --cpu-percent=10
```

kubectl get event |grep -i rescale
2m45s       Normal    SuccessfulRescale         horizontalpodautoscaler/currency-exchange                 New size: 2; reason: cpu resource utilization (percentage of request) above target
49s         Normal    SuccessfulRescale         horizontalpodautoscaler/currency-exchange                 New size: 3; reason: cpu resource utilization (percentage of request) above target

```
kubectl get hpa
```

kubectl get hpa currency-exchange -o yaml > hpa_currency-ex.yaml
구버전이랑 다르게 양식이 좀 달라진 거 같아서 추가로 나열한다.
<details>
<summary>접기/펼치기</summary>
  
apiVersion: autoscaling/v2   
kind: HorizontalPodAutoscaler   
metadata:   
  name: currency-exchange   
  namespace: default   
spec:   
  maxReplicas: 3   
  metrics:   
  - resource:   
      name: cpu   
      target:   
        averageUtilization: 10   
        type: Utilization   
    type: Resource   
  minReplicas: 1   
  scaleTargetRef:   
    apiVersion: apps/v1   
    kind: Deployment   
    name: currency-exchange   
</details>

## Step07. 쿠버네티스 클러스터 삭제
---
쿠버네티스 클러스터는 어플리케이션 배포 여부와 관계없이 기본적으로 비용이 청구된다.
클러스터를 사용할 때는 비용적 측면을 반드시 고려해야한다.
