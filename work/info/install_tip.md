# 각종 설치 팁

## nvm 명령어 설치방법

nvm 이란 NodeVersionManager 를 의미한다.
nodejs 의 버전을 관리해주는 프로그램이다.
```
wget -qO- https://raw.githubusercontent.com/nvm-sh/nvm/v0.35.2/install.sh | bash   
```
```
vi ~/.bashrc   
export NVM_DIR="$HOME/.nvm"
[ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh"  # This loads nvm
[ -s "$NVM_DIR/bash_completion" ] && \. "$NVM_DIR/bash_completion"  # This loads nvm bash_completion
source ~/.bashrc
```

---
## mvn 명령어 설치방법


