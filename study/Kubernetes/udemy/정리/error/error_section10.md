# Section10 
## istion v1.2.2 가 너무해
###### 는 너무 구버전이다.
```
kubectl create namespace istio-system
curl -L https://git.io/getLatestIstio | ISTIO_VERSION=1.2.2 sh -
for i in install/kubernetes/helm/istio-init/files/crd*yaml; do kubectl apply -f $i; done
```
> istio v1.2.2 설치를 위한 yaml 파일들이 너무 옛스럽다..
---

### 내가 취할 수 있는 선택지   
#### (1) istio 버전이 달라서 발생하는 현상을 방지하기 위해 v1.2.2 의 yaml 을 보수공사한다.   
#### (2) 강의를 관망한다.   
#### (3) 최신 버전의 istio 를 설치한다.   


#### (1) istio 버전이 달라서 발생하는 현상을 방지하기 위해 v1.2.2 의 yaml 을 보수공사한다.   
내 이럴 줄 알았지. crd*.yaml 파일들이 version 호환 및 해당 version 에 맞지않는 yaml 양식으로 명령어 돌리니 난리난다 난리나.
```
CustomResourceDefinition in version "v1" cannot be handled as a CustomResourceDefinition: strict decoding error: unknown field "spec.version"
```
https://kubernetes.io/docs/concepts/extend-kubernetes/api-extension/custom-resources/
https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/

와.. 진짜 고통이네.. 어떻게 저떻게 apiVersion 이랑 versions 부분을 docs 보고 따라해서 수정했는데, 정작 수정한 versions 가 v1 에서는 사용 안한다는 거 같은데 ..
yaml 형식이 제법 많이 바뀐거 같은데 그냥 이 강의는 청강만 하는 게 합리적일까 이거를 뜯어고치는 게 합리적일까.
언젠가를 생각해보면 해보는 게 맞는 거 같기는 한데.
```
CustomResourceDefinition in version "v1" cannot be handled as a CustomResourceDefinition:
json: connaot unmarshal object in to Go struct filed CustomResourceDefinitionSpec.spec.versions of type []v1.CustomResourceDefinitionVersion
```

sed -i 's/v1beta1/v1\n/' 
sed -i 's/version:/versions:\n/' 
sed -i 's/v1alpha1/v1\n/' 

지성은 없지만 노가다는 있다.


#### (2) 강의를 관망한다.   
공부할 생각이 진정 없구나. 

#### (3) 최신 버전의 istio 를 설치한다.   




sed -i ''
