# Section10. 쿠버네티스 내 자바스프링부터 마이크로 서비스와 lstio 통합하기
## Step01. istio 활용하여 새로운 쿠버네티스 클러스 생성하기
## Step02. istio Service 메시, 사이크카 패턴
## Step03. 쿠버네티스 클러스터에 istio 설치하기 - CRD 및 istio 컴포넌트
## Step04. istio 설치 검토 및 사이드카 패턴을 활용한 스프링부터 앱 배치
## Step05. 쿠버네티스 클러스터 규모를 3 노드로 확장하기   
## Step06. Istio 게이트웨이와 시각화 서비스 이해하기
## Step07. 기본 배치 전략 - 롤링 업데이트와 재생성
## Step08. 스프링 부트 어플리케이션의 다양한 버전 셋업하기
## Step09. 미러링을 위한 도착지 규칙 및 Subsets 구축하기
## Step10. 쿠버네티스를 활용하여 블루그린과 카나리 배치 수행하기
## Step11. 스프링 부트 마이크로서비스의 Istio 통합 검토하기
## Step12. Kiali로 Istio 서비스 메쉬 관찰하기
## Step13. Graphana and Prometheus로 Istio 서비스 메쉬 관찰하기
## Step14. 스프링 부트 마이크로서비스 트레이싱을 Istio와 Jaegar로 배포하
## Step15. lstio 를 활용한 쿠버네티스 클러스터 삭제하기
---

작업 내용 요약
: 강의에서 제공해준 istio 같은 경우 버전이 1.2 버전인데, 현재 제공되고 있는 GKE Cluster 버전과는 호환이 되지 않아서 불가피하게 최신 버전 설치를 할 수밖에 없었다.
: 현재 사용중인 쿠버네티스 버전은 1.26 버전대이며 이 버전에 호환되는 istio 버전은 1.20 버전대라고 한다.
: 어떻게 저떻게 열심히 설치해서 테스트하기는 했는데 이 방법이 옳은 방법인지는 잘 모르겠다.
https://github.com/ormazed/ormazed.github.io/blob/main/study/Kubernetes/udemy/%EC%A0%95%EB%A6%AC/error/error_section10.md


참고
: https://cloud.google.com/learn/what-is-istio?hl=ko
: https://istio.io/latest/docs/setup/install/
```


---
아니..  왜 잘 되다가 갑자기 gcloud auth login 을 하면 로그인 token 발행 링크 말고도 `START /usr/bin/firefox "https://accounts.google.com/o/oauth2/auth?(중략)` 메세지가 계속 나오냐고..
갑자기 firefox 브라우저가 뜨면서 white page 가 되네.. 미쳐버리겠다 정말..
