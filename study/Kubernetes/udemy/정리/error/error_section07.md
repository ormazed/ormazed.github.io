# Section07
## Stop11
### ingress.yaml 로 생성된 Ingress 가 정상 인식되지 않는 원인을 찾아서.

원문
```
apiVersion: extensions/v1beta1
kind: Ingress
metadata:
  name: gateway-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - http:
      paths:
      - path: /currency-exchange/*
        backend:
          serviceName: currency-exchange
          servicePort: 8000          
      - path: /currency-conversion/*
        backend:
          serviceName: currency-conversion
          servicePort: 8100
```

수정 ( 2024-01-16 정상동작 확인)
```
apiVersion: networking.k8s.io/v1 #수정
kind: Ingress
metadata:
  name: gateway-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - http:
      paths:
      - path: /currency-exchange/*
        pathType: ImplementationSpecific #수정
        backend:
          service: # 이하 수정
            name: currency-exchange
            port:
              number: 8000
      - path: /currency-conversion/*
        pathType: ImplementationSpecific #수정
        backend:
          service: #이하 수정
            name: currency-conversion
            port:
              number: 8100

```
ㅇ 참고 
: https://cloud.google.com/kubernetes-engine/docs/concepts/ingress?hl=ko#multiple_backend_services
: https://cloud.google.com/kubernetes-engine/docs/tutorials/http-balancer?hl=ko

---
### 발생에러

한 번에 되는 걸 보지를 못하지...ingress.yaml 로 Ingress 를 생성하고 나서 GKE 의 Ingress 란을 보니 아래와 같은 메세지가 떠있었다.

(발생1)
```
Translation failed: invalid ingress spec: failed to validate prefix path /currency-exchange/* due to invalid wildcard; failed to validate prefix path /currency-conversion/* due to invalid wildcard
```

(발생2)
ingress.yaml 의 path 가 "" 로 묶여야하나.. 싶어서 묶고 나니 또 이런 메세지가 확인된다.
```
Missing one or more resources. If resource creation takes longer than expected, you might have an invalid configuration.
```

---

### 추가
