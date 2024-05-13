Section2 기본적인 도커 클라이언트 명령어 알아보기
# Redis 를 이용한 컨테이너 이해
docker run redis
docker exec -it CONTAINERID redis-cli
================================================================
Section3 직접 도커 이미지를 만들어 보기
# Docker 이미지 생성하는 순서
dcoker create 이미지명
Dockerfile 작성 >> Docker Clinet >> Docker Server >> 이미지 생성

# Docker File 을 만드는 순서
1. 베이스 이미지를 명시
> Docker 이미지는 여러개의 레이어로 구성
> 베이스 이미지는 가장 기본 단계
> 베이지 이미지 위의 추가적인 단계를 레이어로 이해하면 된다.

2. 추가적으로 필요한 파일을 다운받기 위한 명령어를 명시
3. 컽테이너 시작시 실행될 명령어를 명시

# Dokcerfile -> Dokcer img 생성방법
Dockerfile => Docker 클라이언트 => Docker Server => img
* docker build 명령어를 사용

docker build .
docker image ls

> baseImg 를 통한 명령어/spec 참고
> baseImg 기반의 임시 컨테이너 생성방법
> 임시 컨테이너에 custom한 CMD/Spec 추가(layer)
> 임시 컨테이너로 이미지 생성 후 임시 컨테이너 제거
> 새로운 이미지가 생성

baseImg 에서 다른 종속성이나 새로운 커멘드를 추가할 때는
임시 컨테이너를 만들 후 그 컨테이너를 토대로 새로운 이미지를 생성한다.
(* 임시 컨테이는 삭제된다.)

# docker img 에 별칭붙이기
docker build -t 도커아이디/저장소명:버전 .

Section4 도커를 이용한 간단한 Node.js 어플 만들기
# Node.js 앱 만들기 순서
(1) package.json : 프로젝트의 정보와 프로젝트에서 사용 중인 패키지의 의존성을 관리하는 파일 
    > npm init => package.js 설치
    + express 설치 : 

(2) server.json : Entry Point 로서 가장 먼저 실행되는 파일; Node.js 가 실행될 때 어떤 파일 순으로 읽어들일지를 지정
 
# Dockerfile 작성하기
**************************
FROM : 이미지 생성시 기반이 되는 이미지 레이어
       <이미지이름>:<태그>형식으로 작성
       태그를 안 붙이면 자동적으로 최신것을 다운받음
RUN : 도커이미지가 생성되기 전에 수행할 명령어
CMD : 컨테이너가 시작되었을 때 실행할 실행 파일 또는 쉘 스크립트
      Dockerfile 내 1회만 사용가능       
**************************
- npm 은 Node.js 로 만들어진 모듈을 웹에서 받아서 설치하고 관리하는 프로그램
- npm install 은 package.json 에 적혀있는 종속성들을 웹에서 자동으로 다운받아서 설치해주는 명령어
- 현재 노드 JS 앱을 만들 때 필요한 모듈들을 다운받아 설치하고

* Dockerfile
(1) RUN npm install
(2) NPM Registry 모듈 저장소 -> Module downloaded
(3) Module installed in Application
(4) CMD["node", "server.js"]

# package.json 파일이 없다고 나오는 이유
npm install 명령어 사용 시
(1) 어플리케이션에 필요한 종속성을 다운
(2) 다운받을 때 먼저 package.json 을 보고 그곳에 명시된 종속성들을 다운받아서 설치
(3) package.json 컨테이너 안에 없기에 찾을 수 없다는 에러가 발생
**************************
FROM node:10
COPY package.json ./
RUN npm install
CMD ["node","server.js"]
**************************

# 생성한 이미지로 어플리케이션 실행 시 접근이 안 되는 이유
docker run -p 8080:8080 이미지명

# Working Directory 명시
**************************
WORKDIR /usr/src/app

* WORKDIR : 어플리케이션 소스 코드를 갖고 있는 디렉토리를 생성되기
- WORKDIR 가 필요한 이유
: 이미지를 별도로 생성할 때 WORKDIR 경로를 지정하지 않으면 COPY 명령어 실행 시 
  컨테이너의 ROOT 경로에다가 쌓이게 된다.
  >> 동일명의 파일이나 경로가 있을 경우 덮어쓰기가 될 수 있다.
: 어플리케이션과 관련된 소스들을 WORKDIR 에서 한 번에 관리하기 위함이다.
**************************

# 어플리케이션 소스 변경으로 다시 빌드하는 것에 대한 문제점
어플리케이션 개발 시 변겨되는 소스코드를 매번 재빌드해야하는 점의 번거로움이 발생
(기존) Dockerfile 작성 => Dockerfile 로 Docker 이미지 생성 => Docker 이미지로 컨테이너 생성 후 앱 실해


# 어플리케이션 소스 변경으로 재빌드 시 효율적으로 하는 방법
**************************
COPY package.json ./
RUN npm install
COPY ./ ./
>> COPY ./ ./ 한 번만 동작시킬 경우, 캐시가 되기 때문에 변경한 어플리케이션을 인식하지 못하게 된다.
>> COPY 를 pacakage.json 과 source 로 분리하여 하게 될 경우 종속성을 다운받는 단계와 소스 변경을 가져오는 부분을
분리할 수 있게 되어 효율성이 증대된다.
**************************


# Docker Volume 에 대하여
**************************
docker run -p 8080:8080 -v /usr/src/app/node_modules -v $(pwd):/usr/src/app lena/nodejs
docker run -p 로컬포트:컨테이너포트 -v 제외할 경로 -v 참조할로컬경로:WORKDIR 이미지ID
* /usr/src/app/node_modules : 
* $(pwd):/usr/src/app
node_modules 를 제외하고 $(pwd) 의 모든 파일을 컨테이너 내 /usr/src/app 경로로 참조하라는 의미
**************************

================================================================
Section5 Docker Compose
- package.json 에 작성한 "script" 부분의 key 값이 npm run 명령어에서 사용하는 옵션으로 동작한다
(ex) npm run start --> "script" 내 key 값이 start 인 value 가 동작하게 된다.

# Docker Compose 란 무엇인가
# 어플리케이션 소스 작성하기
# Dockerfile 작성하기

# Docker Containers 간 통신할 때 나타나는 에러
Nodejs 가 동작하는 Container(Container1) 와 Redis 가 동작하는 Container(Container2) 가
서로 다르기 때문에 기본적으로 Connection 이 되지 않고 별도의 작업이 필요해진다.
> 이러한 작업의 피로도를 줄이기 위한 기능이 Dokcer Compose 이다
(멀티 컨테이너 상황에서 쉽게 네트워크를 연결시켜주기 위한 기능)

# Docker Compose 파일 작성하기
> docker-compose.yaml 형식으로 작성
**************************
컨테이너 이름 : redis-server (redis 이미지 사용 명시)
컨테이너 이름  : node-app (Dockerfile 사용 -> 포트 매핑)
**************************
docker-container.yaml 에 작성한 대로
우선 docker image 를 build => yaml services 에 나열한 순서대로 server 기동

# Docker Compose 로 컨테이너를 멈추기
* docker compose 명령어를 사용하기 위해서는 docker-compose.yaml 이 작성된 경로로 이동해야한다.
docker compose up (이미지 필요시 빌드)
docker compose down
docker compose up --build (이미지를 항상 재빌드)
docker compose -d up (백그라운드 실행)

================================================================
Section6 간단한 어플을 실제 배포해보기(개발)
# 리액트 앱 설치하기
* react 설치
npx create-react-app ./

* react application 관련 명령어
개발단계 : npm run start
테스트 단계 : npm run test
배포환경 : npm run build

# 도커를 이용하여 리액트 앱 실행하기
* Docker 로 React 실행
Docker img 생성 => img 로 Container 생성 => Container 안에 앱 실행
Dockerfile - (DEV) Dockerfile.dev / (PROD) Dockerfile

테스트 환경을 보면 node_modules 라는 경로가 있는데 container 가 생성될 때, 
RUN npm install 덕에 container 내부에 node_modules 가 생성되될 예정이기에 굳이 COPY 할 필요가 없다.

* Docker.dev 의 경우, docker build 시 Dockerfile 과 달리 인식하지 못한다.
docker build -f Dockerfile.dev -t lena/react-app-dev
(build -f 옵션을 통해 이미지 빌드 시 참고할 파일을 지정)
docker run -p 3000:3000 lena/react-app-dev

# 생성된 도커 이미지로 리액트 앱 실행하기
docker run -p 3000:3000 -v /usr/src/app/node_modules -v $(pwd):/usr/src/app lena/react-app-dev

# 생성된 도커 이미지로 리액트 앱 실행하기
# 도커 볼륨을 이용한 소스 코드 변경
# 도커 컴포즈로 좀 더 간단하게 앱 실행하기
vi docker-compose.yaml
**************************
version : Docker Compose 의 버전
services : 실행하려는 컨테이너들을 정의
react : 컨테이너의 이름
build : 현 디렉토리에 있는 Dockerfile 사용
context : 도커 이미지를 구성하기 위한 파일과 폴더들이 있는 위치
dockerfile : 어떤 도커 파일인지 지정
ports : 포트 매핑
volumes : 로컬 머신에 있는 파일들을 맵핑
stdin_open : 리액트 앱을 끌 때 필요
**************************

# 리액트 앱 테스트하기
docker run -it lena/docker-react-app npm run test
vi docker-compose.yaml
**************************
tests: 컨티이너 이름
build : 현 디렉터리에 있는 Dockerfile 사용
context : 도커 이미지를 구성하기 위한 파일과 폴더들이 있는 위치
dockerfile : 사용할 도커 파일 명 지정
volumes : 로컬 머신에 있는 파일을 맵핑
command : 테스트 컨테이너 시작할 때 실행되는 명령어
**************************

# 운영환경을 위한 Nginx
# 운영환경 도커 이미지를 위한 Dockerfile 작성하기
**************************
FROM node:alpine as builder
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
COPY ./ ./
CMD ["npm","run","build"]

FROM nginx
COPY --from=builder /usr/src/app/build /usr/share/nginx/html
(1) --from=builder : 다른 stage 에 있는 파일을 복사할 떄 다른 stage 이름을 명시
(2) /usr/src/app/build /usr/share/nginx/html
: builder stage 에서 생성된 파일들은 /usr/src/app/build 에 들어가게 되며 그곳에 저장된 파일들을 /usr/share/nginx/html 로 복사를 시켜줘서 nginx 가 웹 브라우저의 http 요청이올때 알맞은 파일을 전해줄 수 있게 만듭니다.
**************************

docker build . -t lena/docker-react-app
docker run -p 8080:80 lena/docker-react-app
================================================================
Section7 간단한 어플을 실제 배포해보기(배포)
# Travis CI 설명
# Travis CI 이용 순서
>> 젠킨슨와 비슷한 기능을 하는 자동 배포화 도구

# .travis.yml 파일 작성하기
(1) Test 를 수행하기 위한 준비
- Travis CI 에 Docker 환경 구성
- 구성된 Docker 환경에서 Dockerfile.dev 를 이용해서 도커 이미지 생성
(2) Teset 를 수행하기
- 어떻게 Test 를 수행할 것인지 설정해주기
(3) AWS 로 배포하기
- AWS 에 소스코드를 배포할 것인지 설정

.travis.yml
**************************
sudo : 관리자 권한갖기
language : 언어 선택
services : Docker 환경 구성
before_install : 스크립트를 실행할 수 있는 환경 구성
  > Dockerfile 을 통한 이미지 구성을 하는 단계
script : 실행할 스크립트(테스트 실행)
after_success : 테스트 성공 후 할일
**************************

* Travis CI 사용방법
(1) Plan 설정이 필요하다
(2) ssh 권한이슈
If you have SSH keys defined for your repositories, please review their settings now. 
The new Share ssh keys with forks (PRs) repository setting are present and set to ON for repositories already in Travis CI in order to not break existing build setups. 
ㅇ travis 공식문서
https://docs.travis-ci.com/user/private-dependencies/#password
ㅇ travis 명령어 설치
https://velog.io/@kyungwoon/TIL-%ED%95%AD%ED%95%B499-Day-76
https://zetawiki.com/wiki/CentOS_rubygems_%EC%84%A4%EC%B9%98
ㅇ ruby 2.3 이상 필요
https://www.infracody.com/2022/06/install-ruby-rvm-on-centos-7-linux.html


# AWS 알아보기
# Elastics Beanstalk 환경 구성하기

# AWS 업데이트 : Elastics Beanstalk branch
# .travis.yml 파일 작성하기(배포부분)
# Travis CI 의 AWS 접근을 위한 API 생성
* Secret, Access API Key 받는 순서
(1) IAM USER 생성
(2) API 를 Travis yml 파일에 작성

# AWS 업데이트 : ElasticsBeanstalkFullAccess
ㅇ IAM User 권한변경 : ElasticsBeanstalkFullAccess > AdministratorAccess-AWSElasticBeanstalk

# Travis CI 에서 Github Action 으로 교체하기
(1) AWS IAM Role 추가
> AWSElasticBeanstalkMulticontaienrDocker
> AWSElasticBeanstalkWebTier
> AWSElasticBeanstalkWorkerTier
(2) ElasticsBeanstalk 생성
(3) 사용자 생성 => access key 생성
(4) Amazon S3 bucket
(5) github repository 생성 => 경로 생성: .github\workflow\deploy.yaml

================================================================
Section8 복잡한 어플을 실제 배포해보기(개발)
# Node JS 구성하기
(1) backend란느 폴더 생성하기(Nodejs 관련 소스 경로)
(2) package.json 파일 생성
pacakage.json
**************************
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "start": "node server.js",
    "dev": "nodemon server.js", 
  },
  "dependencies": {
    "express": "^4.16.1", // 웹 프레임워크 모듈
    "mysql": "2.16.0", // mysql 을 사용하기 위한 모듈
    "nodemon": "1.18.3", // source 변경 시 자동 재기동 수행해주는 모듈
    "body-parser": "1.19.0" // 클라이언트에서 오는 요청의 본문을 해석해주는 미들웨어
  }
**************************
(3) package.json 파일 안에 스크립트와 사용할 모듈들 명시
(4) 시작점이되는 server.js 생성
(6) mysql 연결을 위한 db.js 파일 생성
(7) HOST, USER, PW, DB명 명시하여 POOL 생성; 생성한 POOL 을 다른 부분에서 쓸 수 있게 export 해줌.
(8) export 된 POOL 을 시작점인 server.js 에서 불러오기
(9) 이 어플에서 필요한 API 작성

# React JS 구성하기
(1) Create-React-App 으로 리액트앱 생성하기 
> npx create-react-app frontend
(2) 리액트 앱 생성
> npm run react
(3) App.js 파일 안에 원하는 UI 생성 : Input 박스 Button 추가
(4) UI 를 위한 코드 작성
(5) UI 를 위한 CSS 작성
(6) 데이터 흐름을 위한 State 생성
**************************
import React, { useState } from 'react' // useState 를 사용하기 위해서 react 라이브러리에서 가져옴
..(중략)..
fucntion App(){
  const [lists, setLists] = useState([]) // lists : DB 에 저장된 값을 가져와서 화면에 보여주기 전 이 State 에 넣어둠
  const [value, setValue] = useStae(") // input 박스에 입력한 값이 이 state 에 저장됨
}
**************************




# 리액트 앱을 위한 도커 파일 만들기
**************************
FROM node:alpine asbuilder
쨰까앾 /app
COPY ./pcakage.json ./
RUN npm install
COPY ./ ./
RUN npm run builder
FROM nginx
EXPOSE 3000
COPY ./nginx/default. conf /etc/nginx/default.conf
COPY --from=builder /app/build /usr/share/nginx/html
**************************
mkdir -p frontend/nginx
touch frontend/nginx/default.conf
default.conf
**************************
server{
  location / {
    root /usr/share/nginx/html
    index index.html index.htm
    try_files $uri $uri /index.html  //React Router 를 사용해서 페이지 간 이동할 때 사용
  }
}
ㅇ React 는 Single Page Application 이도
> index.html 하나의 정적 파일만 가지고 이고 {URL}/home 으로 접근하려고 해도 {URL}/home/index.html 로 이동되야한다
> nginx 는 위의 기능을 구현하고 있지 않다(인식x)
> 따라서 /home 에 접속하려고 할때 /home 에 매칭되는 것 이없다면 대안으로 index.html 을 제공하여 /home 경로를 라우팅하는 설정

**************************
# 노드 앱을 위한 도커 파일 만들기

# DB에 관해서

# MYSQL을 위한 도커 파일 만들기
1. backend\mysql\Dockerfile
2. Dockerfile 작성 : FROM mysql:5.7
3. Database 와 Table 생성 위치 : backend\mysql\slqs\initialize.sql
4. Database 와 Table생성
initialize.sql
*******************************
DROP DATABASE IF EXISTS myapp;
CRATE DATABASE mysapp;
USE myapp;

CRATE TABLE lists (
  id INTGER AUTO_INCREMENT,
  value TEXT,
  PRIMARY KEY (id)
);
*******************************
5. mysql 인코딩 설정 : backend\mysql\my.conf 작성
ㅇ my.conf
*******************************
[mysqld]
character-set-server=utf8
[mysqld]
default-character-set=utf8
[client]
dfeault-character-set=utf8
*******************************
ㅇ Dockerfile
*******************************
FROM mysql:5.7
ADD ./my.conf /etc/mysql.conf.d/my.cnf
*******************************

# NGINX를 위한 도커 파일 만들기
Nginx 가 context 를 기준으로 정적파일 처리(/)와 API 요청 처리(/api)로 분기되고 있는 상테
- 정적파일 처리 : React JS
- API 요청 처리 : Node JS
Nginx 가요청을 나눠서 보내주는 기준의 lolcation {Context정보}
1. nginx 폴더와 dfeault.conf 파일, Dockerfile 생성
> frontend\nginx != nginx
2. default.conf 작성
ㅇ default.conf
*******************************
upstream frontend {
  server fronted:3000
}

upstream backend {
  server backend:5000
}

server {
  listen 80;
  location / {
    proxy_pass http://frontend;
  }

  location /api {
    proxy_pass http://backend;
  }

  // error처리용
  location /sockjs-node {
    proxy_pass http://fronted;
    proxy_http_version 1.1;
    proxy_set_header Upgrade $http_upgrade;
    proxy_set_header Connection "Upgrade";
  }
}
*******************************
3. Nginx 를 위한 Dockerfile 작성
*******************************
FROM nginx
COPY ./default.conf /etc/nginx/conf/default.conf
*******************************
# Docker Compose 파일 작성하기
1. docker-compose.yaml 파일 생성
2. 각각의 서비스들을 작성
*frontend / backend / nginx / mysql 
3. 기동 : docker-compose up

docker-compose.yaml
*******************************
version: "3"
services:
  frontend:
    build:
      dockerfile: Dockerfile.dev
      context: ./frontend
    volumes:
      - /app/node_modules
      - ./frontend:/app
    stdin_open: true
  nginx:
    restart: always
    build:
      dockerfile: Dockerfile.dev
      context: ./nginx
    ports:
      - "3000:80"
  backend:
    build:
      dockerfile: Dockerfile.dev
      context: ./backend
    container_name: app_backend
    volumes:
      - /app/node_modules
      - ./frontend:/app
  mysql:
    build: ./mysql
    restart: unless-stopped
    container_name: app_mysql
    ports:
     - "3306:3306"
    volumes:
      - ./mysql/mysql_data:/var/lib/mysql
      - ./mysql/sqls:/docker-entrypoint-initdb.d/
    environment:
      MYSQL_ROOT_PASSWORD: admin1234
      MYSQL_DATABASE: mysapp
*******************************
ㅇ 재시작 정책(restart)
no : 재시작 x
always: 항상 재시작
on-failure: on-failure 에러코드와 함께 컨테이너가 멈춘 경우에만 재시작
unless-stopped : 개발자가 임의로 중지할 때 빼고는 항상 재시작



# Docker Volume을 이용한 데이터 베이스 데이터 유지하기

================================================================
Section9 복잡한 어플을 실제 배포해보기(배포)
# 도커 환경의 MYSQL부분 정리하기
ㅇdocker-compose.yaml
*******************************
version: "3"
services:
  frontend:
    build:
      dockerfile: Dockerfile.dev
      context: ./frontend
    volumes:
      - /app/node_modules
      - ./frontend:/app
    stdin_open: true
  nginx:
    restart: always
    build:
      dockerfile: Dockerfile.dev
      context: ./nginx
    ports:
      - "3000:80"
  backend:
    build:
      dockerfile: Dockerfile.dev
      context: ./backend
    container_name: app_backend
    volumes:
      - /app/node_modules
      - ./frontend:/app
*******************************

# Github에 소스 코드 올리기
cd docker-fullstack
touch backend/.gitignore
ㅇ ./gitignore
*******************************
node_moduels
*******************************
touch backend/.gitignore
ㅇ ./gitignore
*******************************
mysql_data
*******************************

git init
git add .
git commit -m "first commit"
git remote add origin 경로
git push origin master


# Travis CI Steps
(1) github 에 코드 푸시
(2) Travis CI 가 자동으로 코드를 가져옴
(3) 가져온 코드로 테스트 코드 실행 
(4) 성공 => 운영 환경 이미지들을 Build 
(5) Build 된 이미지들을 Docker Hub 로 전달
(6) AWS EB 에 DockerHub 에 이미지를 보냈다고 전달
(7) AWS EB 에서 DockerHub 에 있는 이미지를 가져온 후에 배포

# .travis.yml 파일 작성하기
(1) .traivs.yaml 파일 생성
(2) Test 수행을 위한 준비 
- 앱을 도커 환경에서 실행하고 있으니 Travis CI 에게 도커 환경으로 수행됨을 선언
- 구성된 도커 환경에서 Dockerfile.dev 를 이용해서 도커 이미지 생성
(3) Test 수행
- 생성된 테스트 이미지로 테스트 수행
(4) 모든 프로젝트의 운영버전 이미지를 빌드
- 테스트가 성공했다면 개별 프로젝트의 운영버전 이미지를 빌드하는 설정 추가
(5) 빌드된 이미지를 DockerHub 로 전달
(6) 배포하기 : AWS EB 에서 DockerHub 의 업데이트된 빌드 이미지를 가져와서 배포할 수 있도록 설정

ㅇ .travis.yaml
*******************************
laguage: generic
sudo: required
services:
  - docker
before_install:
  - docker build -t lena/react-test-app -f ./frontend/Dockerfile.dev ./frontend
script:
  - docker run -e CI=ture lena/react-test-app npm run test
after_success:
  - docekr build -t lena/docker-fronted ./frontend
  - docker build -t lena/docker-backend ./backend
  - docker build -t lena/docker-nginx ./nginx

  - echo "$DOCKER_HUB_PASWORD" | docker login -u "$DOCKER_HUB_ID" --password-stdin
  - docekr push lena/docker-fronted ./frontend
  - docker push lena/docker-backend ./backend
  - docker push lena/docker-nginx ./nginx
*******************************

# Dockerrun.aws.json에 대해서
: Dockerfile 이 여러개일 때 개별 파일의 동작 순서를 정의
> 업무 프로세스를 정의 Task Definition + Contaienr Definition 명시

# Dockerrun.aws.json 파일 작성하기
ㅇ Dockerrun.aws.json
*******************************
"containerDefinitions": { // 이 객체안에서 개별 컨테이너를 정의
  "name": "nginx", // 컨테이너 명
  "image: "lena/docker-nginx", // Docker 컨테이너를 구축할 온라인 Docker repo 의 Docker 이미지 이름
  "hostname": "nginx", // 호스트명 ; docker-compose 를 이용해 생성된 다른 컨테이너에서 접근 가능
  "essentail": true, // 컨테이너 작업 실패 시 작업 중지를 바랄 경우 true
  "portMappings": [{ // 컨테이너에 있는 네트워크 지점을 호스트에 있는 지점과 매핑
    "hostPort": 80,
    "contaienrPort": 80
  }],
  "links": ["frontend", "backend"], // 연결한 컨테이너 목록 
  "memory": 128
}
*******************************

# 다중 컨테이너 앱을 위한 Elastic beanstalk 환경 생성
# VPC(virtual private cloud)와 Security Group 설정하기
# MYSQL을 위한 AWS RDS 생성하기
# Security Group 생성하기
# Security Group 적용하기
# EB와 RDS 소통을 위한 환경 변수 설정하기
# travis.yml 파일 작성하기 (배포 부분)
# Travis CI의 AWS 접근을 위한 API key 생성
# Fullstack App Travis CI 에서 Github Action으로 교체하기(시작부터 배포까지)
================================================================

