# 각종 설치 팁

## nvm 명령어 설치방법

nvm 이란 NodeVersionManager 를 의미한다.
nodejs 의 버전을 관리해주는 프로그램이다.
```
wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.2/install.sh | bash   
vi ~/.bashrc   
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion
source ~/.bashrc
```

---

## mvn 명령어 설치방법

CentOS7 환경에서 Maven 을 yum 으로 설치하면 `3.0.5` 가 가능하다.

Q. docker 버전과 maven 버전의 호환성 문제는 없을까?

* maven 압축 파일 다운로드   
```
wget https://archive.apache.org/dist/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz
tar xvzf apache-maven-3.6.3-bin.tar.gz
mv apache-maven-3.6.3/ maven-3.6.3
```   
* maven 환경 변수 설정   
```
vi /etc/profile.d/maven.sh
export MAVEN_HOME=/opt/maven-3.6.3
export PATH=$PATH:$MAVEN_HOME/bin

source /etc/profile.d/maven.sh
```   
* maven 확인   
```
mvn --version
```   

* 참고
  * https://developer-woong.tistory.com/46
  * https://www.rosehosting.com/blog/install-apache-maven-3-5-on-centos-7/
