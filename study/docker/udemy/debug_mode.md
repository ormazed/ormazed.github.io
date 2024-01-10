### Docker tip

### docker debug mode
docker info 명령어를 사용했을 때 Debug Mode 가 false 인거를 true 로 바꾸고 싶을 때.
docker 에서 생성하는 log 의 level 을 낮추고 싶을 떄( 로그 양상을 보니까 default 가 info 로 추정)

> 방법(1) docker -D

> 방법(2) vi /etc/docker/daemon.json   
{
  "log-driver": "json-file",   
  "log-opts": {   
    "max-size": "10m",   
    "max-file": "3"   
  },   
  "debug": true   
}   

systemctl restart docker

journalctl -xe |grep docker

chatGPT 압도적 감사!

테스트해봤는데 vi /etc/docker/daemon.json 에 { "debug": true} 만 작성했었을 때는 안됐었다. 
분명 검색해보니까 debug ture 만 하면 된다는 본문 내용이 많았는데 버전 차이인지는 모르겠지만 좀 확인해보면 좋을 부분일듯 하다.

