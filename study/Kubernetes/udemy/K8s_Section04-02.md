# Section04 GKE-쿠버네티스에서 선언형 설정 활용하기

## Step01 쿠버네티스 YAML 설정 이해하기 - 레이블과 셀렉터

---
## Step02 minReadySeconds 를 활용하여 릴리즈 소요시간 감소시키기

> `kubectl diff -f YAML파일명`   

현재 동작중인 리소스와 YAML 파일 안에 선언된 리소스를 비교하여 보여준다.


파드가 동작가능하더라도 파드 내에 배포된 어플리케이션이 배포에는 시간이 더 걸릴 수 있다.
* 파라미터 값을 추가하여 파드 동작까지 시간 지연 가능
`minReadySeconds`
어플리케이션이 배포되는데 필요한 시간만큼을 추가하여 파드 동작과 어플리케이션 동작 사이의 갭을 줄일 수 있다.
 

---
## Step03 쿠버네티스 YAML설정을 활용한 레플리카 세트의 심화 이해하기

#### deployment vs replicaset
* deployment : 어플리케이션의 버전을 관리/배포하는 등에 사용.   
* replicsset : 일정한 개수의 pod 가 유지될 수 있도록 함,   

replicaset 은 버전에 관계없이 일정 개수의 pod 가 유지되기만 하면 된다.

---
## Step04 One Service 를 활용한 여러 쿠버네티스 배치 설정하기