# Section02 쿠버네티스와 구글 쿠버네티스 엔진(GKE) 시작하기
## Step03 GKE 생성하기
### Google Cloud UI 상에서 생성하는 방법 외 개별 서버에서 접속하는 방법
* 설치된 서버에 gcloud 명령어가 없는 상태
```
sudo yum list gcloud
```

```
sudo tee -a /etc/yum.repos.d/google-cloud-sdk.repo << EOM
[google-cloud-cli]
name=Google Cloud CLI
baseurl=https://packages.cloud.google.com/yum/repos/cloud-sdk-el9-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=0
gpgkey=https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
EOM
```

```
ls -al /etc/yum.repos.d/google-cloud-sdk.repo
```

```
sudo yum update
```   
* 출처 : https://cloud.google.com/sdk/docs/install-sdk?hl=ko#rpm


---
(시도1)   
gcloud container clusters get credentials in8minutes-cluster --zone us-centrall-a -project theta-style-403004   
gcloud auth login    

(시도2)
gcloud container clusters get-credentials in28minutes-cluster --zone us-centrall-a -project theta-style-403004   
> 에러발생1    
```
Fetching cluster endpoint and auth data.   
kubeconfig entry generated for in28minutes-cluster   
CRITICA ACTION REQUIRED gke-gcloud-auth-plugin, which is needed for continued use of kubectl, was not found or is not executable Install
gke-gcloud-auth-plugin for use with kubectl by following
https://cloud.google.com/blog/products/containers-kubernetes/kubectl-auth-changes-in-gke   
```
> 해결1(docs 참고) gke-gcloud-auth-plugin 설치   
yum install google-cloud-sdk-gke-gcloud-auth-plugin   

> 에러발생2   
```
Transaction check error:
  file /usr/lib64/google-cloud-sdk/platform/bundledpythonunix/lib/itcl4.2.2/libitcl4.2.2.a from install of google-cloud-sdk-458.0.1-1.x86_64 conflicts with file from package google-cloud-cli-458.0.1-1.x86_64
  file /usr/lib64/google-cloud-sdk/platform/bundledpythonunix/lib/itcl4.2.2/libitclstub4.2.2.a from install of google-cloud-sdk-458.0.1-1.x86_64 conflicts with file from package google-cloud-cli-458.0.1-1.x86_64
  file /usr/lib64/google-cloud-sdk/platform/bundledpythonunix/lib/libpython3.11.a from install of google-cloud-sdk-458.0.1-1.x86_64 conflicts with file from package google-cloud-cli-458.0.1-1.x86_64
  file /usr/lib64/google-cloud-sdk/platform/bundledpythonunix/lib/python3.11/config-3.11-x86_64-linux-gnu/libpython3.11.a from install of google-cloud-sdk-458.0.1-1.x86_64 conflicts with file from package google-cloud-cli-458.0.1-1.x86_64
  file /usr/lib64/google-cloud-sdk/platform/bundledpythonunix/lib/thread2.8.7/libthread2.8.7.a from install of google-cloud-sdk-458.0.1-1.x86_64 conflicts with file from package google-cloud-cli-458.0.1-1.x86_64

Error Summary
```
> 해결2   
yum shell   
> remove google-cloud-cli   
> install google-cloud-sdk   
> run   
```
[root@ldy0803 ~]# yum shell
Loaded plugins: fastestmirror, langpacks
> remove google-cloud-cli
> install google-cloud-sdk
Loading mirror speeds from cached hostfile
 * base: mirror.elice.io
 * extras: mirror.elice.io
 * updates: mirror.elice.io
> run
--> Running transaction check
---> Package google-cloud-cli.x86_64 0:458.0.1-1 will be erased
---> Package google-cloud-sdk.x86_64 0:458.0.1-1 will be installed
--> Finished Dependency Resolution
...(Skip)...
```
---
## Step 12 구글 클라우드 콘솔의 GKE 복습   
### Google Cloud Platform   
Kubernetes Engine\Workloads 에서 작업이 가능하다   
---
## Stemp 13 쿠버네티스 아키텍처 이해하기 - Masger Node 와 Worker Node   


