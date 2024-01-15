 # war 파일 톰캣에서 배포한는 방법

## (방법1) 기본방법
tomcat 다운로드 후 압축해제한 경로를 보면 webapps 디렉터리가 존재한다. webapps 디렉터리 경로에다가 war 파일을 넣고 server.xml 혹은 context.xml 파일 안에 Resource 정보를 추가하면 된다.

## (방법2) docBase != appBase 경로를 다르게 설정하는 방법

`docBase` : war 일이 위치한 경로를 의미한다. 
`appBase`: 간단하게 말해서 war 파일로 톰캣에 어플리케이션을 업로드하게 될 경우 war 파일이 압축해제되는 위치를 의미한다

방법1에 빗대어 설명하자면 방법1의 경우는 docBase = appBase ㅣ기 때문에 Tomcat 설치경로￦webapps 에 docBase 와 appBase  가 같이 존재하는 거다. 

다만 이렇게 될 경우 war 파일을 별도 관리하기에 불편하기 때문에 war 파일만을 관리할 docBase 와 실제 어플리케이션이 배포될 appBase 경로를 분리하는 것이다.


```
<Host name="localhost" appBase="webapps" unpackWARs="true" autoDeploy="true">
  <Context path="test" reloadable="true" docBase="/engn001/tomcat/war/test.war" deployOnStartup="true">
  </Context>
</Host>
```

appBase 에서 appBase="webapps" 라고 적혀있는데 이거는 Tomcat 설치경로 이하의 webapps 를 의미한다(상대경로).
즉 만약 톰캣설칙 경로가 /engn001/tomcat/apache-9.0.14 이라면 해당 경로 밑의 webapps 를 의미하는 것이다.
