# Section10. 쿠버네티스 내 자바스프링부터 마이크로 서비스와 lstio 통합하기
## Step01. 
---

## Step02.istio Service 메시, 사이크카 패턴
---

참고
: https://cloud.google.com/learn/what-is-istio?hl=ko
: https://istio.io/latest/docs/setup/install/

```
kubectl create namespace istio-system
curl -L https://git.io/getLatestIstio | ISTIO_VERSION=1.2.2 sh -
for i in install/kubernetes/helm/istio-init/files/crd*yaml; do kubectl apply -f $i; done
``` 


## Step15. lstio 를 활용한 쿠버네티스 클러스터 삭제하기








---
아니..  왜 잘 되다가 갑자기 gcloud auth login 을 하면 로그인 token 발행 링크 말고도 `START /usr/bin/firefox "https://accounts.google.com/o/oauth2/auth?(중략)` 메세지가 계속 나오냐고..
갑자기 firefox 브라우저가 뜨면서 white page 가 되네.. 미쳐버리겠다 정말..

