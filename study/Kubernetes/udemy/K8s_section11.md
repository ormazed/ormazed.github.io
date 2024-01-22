# Section11. Helm 사용하여 쿠버네티스 내 마이크로서비스 배치 자동화하기

## Step01. Helm 의 기본 이해 및 쿠버네티스 클러스터 구척
---

HELM 이란 
: 쿠버네티스를 위한 매니저 기능을 제공(쿠버네티스 어플리케이션을 관리)   
: 쿠버네티스 패키지 관리를 도와주는 것(yaml 파일의 모음)   
chart + Repositry + Release   

 Helm Client <==> Helm Tiller(Server Side)
 Helm Tiller 은 Helm ver2 에서 사용되는 개념으로 보안문제로 인해 v3 에서부터는 사용되지 않는다
 v3 붙어는 Client 에서 바로 API Server 로 요청한다.
 
후.. 이 HELM 이라는 친구도 Kubernetes 버전에 영향을 받는다.   
HELM 3.0.0 은 Kuberneetest1.16.2 클라이언트를 사용(Kubernetes 1.16 과 호환된다.)   
가장 최신 버전인 3.14 버전은 Kubernetes 1.29 버전의 바이너리가 업데이트 되었다.   
HELM 은 향후 호환성을 보장하지 않기 때문에 최신 버전의 Kubernetes 는 HELM 과의 사용이 적합하지 않다.   
-> 나는 어쩌지...강의에서는 helm-v2.0.0 사용하려는 거 같은데..음.. 가장 최신인 2버전대를 설치했을 때 호환이 될까 과연..?   

ㅇ 참고 :  https://helm.sh/docs/topics/version_skew/    
ㅇ 참고 :  https://github.com/helm/helm/releases   

./helm-tiller.sh
```
curl: (23) Failed writing body
./helm-tiller.sh: line 15: helm: command not found
./helm-tiller.sh: line 17: helm: command not found
verify helm
Error
Error from server (NotFound) : deployments.apps "tiller-deploy" not found
from server (NotFound) : services "tiller-deploy" not found
```


#### helm tiller 설치방법



 

## Step02. Helm 차트를 활용한 스프링 부트 마이크로서비스 쿠버네티스 배치
---


## Step03. Helm 차트를 활용하여 쿠버네티스 클러스터 배포 관리하기
---


