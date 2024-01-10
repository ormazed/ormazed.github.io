# Section04 GKE-쿠버네티스에서 선언형 설정 활용하기 
https://lg-cns.udemy.com/course/best-kubernetes-cloud-aws-azure/learn/lecture/29499508#overview

## Step01. 쿠버네티스 YAML 설정 이해하기 - 레이블과 셀렉터
* Docker Hub 에 이미지를 push 하는 것에 실패했더라도 실습이 가능하다.



## Step02. minReadySeconds 를 활용하여 릴리즈 소요시간 감소시키기
` kubectl diff -f {파일명}.yaml`
현재 동작중인 리소스와 YAML 파일 안에 선언된 리소스를 비교하여 보여준다.
파드가 동작가능하더라도 파드 내에 배포된 어플리케이션이 배포에는 시간이 더 걸릴 수 있다.
이때 파라미터 값을 추가하여 어플리케이션이 배포되는 동안은 Pod Runnging 을 지연하는 방법이 있다.

`minReadySeconds ()s`
어플리케이션이 배포되는데 필요한 시간만큼을 추가하여 Pod 동작과 어플리케이션 동작 사이의 갭을 줄일 수 있다.
참고 : https://kubernetes.io/docs/concepts/workloads/controllers/deployment/


## Step03. 쿠버네티스 YAML설정을 활용한 ReplicaSet 의 심화 이해하기
#### Deployment vs Replicaset
* Deployment : 어플리케이션의 버전을 관리/배포하는 등에 사용.   
* Replicsset : 일정한 개수의 pod 가 유지될 수 있도록 함,   

> replicaset 은 버전에 관계없이 일정 개수의 pod 가 유지되기만 하면 되기 때문에 POD 간 Version 이 다른 경우에는 반응하지 않는다.

```
만약 YAML 파일로 kubernetest 를 배포하였을 때
error: unknown field "spec.strategy"
이러한 내용이 나온다면 YAML 에 선언한 리소스(kind) 가 사용하지 않는 field 를 선언한 것이라고 이해하면 된다.
```
## Step04. One Service 를 활용한 여러 쿠버네티스 배치 설정하기


### 질문
실습내용 중  Deployment 가 여러개 일 때 하나의 Deployment 에만 통신이 될 수 있도록 하는 방법에 대한 내용이 있었다(=sticky sessino).
sessionaffinity 를 떠올렸는데, Service 의 selector 를 변경하는 방식을 알려줬다.
sessionAffinity 는 무슨 기능을 하는 걸까? 이런 경우에 sessionAffinity 를 쓰면 동일한 효과가 기대되지 않는 건가..? 

확인해본 바로는
`sessionAffintiy` : sessionAffinity: ClientIP 를 사용하게 되면 특정 IP 에 대한 session sticky 가 유지된다.
`selector`: selector 로 지정된 리소스 전체에 대한 제어가 가능하다. 가령 selector 가 동일하면 IP 가 달라도 무관해질 거 같다.
ㅇ 참고 : https://kubernetes.io/docs/reference/networking/virtual-ips/#session-affinity
