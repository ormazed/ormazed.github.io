### Failed to establish a new connection: [Errno -2] Name or service not known'))
---

한 번에 되면 내가 아니지... 쿠버네티스 클러스터를 새로 생성했으니까 Connect to the cluster 도 새로해야 해서 command 보냈다가 gcloud 로그인하라고 해서 `gcloud auth login` 하니 이런 메세지나 나오네.. 인생..
```
ERROR: gcloud crashed (ConnectionError): HTTPSConnectionPool(host='oauth2.googleapis.com', port=443): 
Max retries exceeded with url: /token (Caused by NewConnectionError('<urllib3.connection.HTTPSConnection object at 0x7f08a837f350>:
Failed to establish a new connection: [Errno -2] Name or service not known'))
```
GCP 에서 나랑 완전 동일한 케이스 Report 작성한 내용이 보이는데, 이거 어떻게 적용하는 거지..   
https://www.googlecloudcommunity.com/gc/Technical-Tips-Tricks/API-Error-nodename-nor-servname-provided-or-not-known/ta-p/586324

헛발질이겠지.. 흠.. 
