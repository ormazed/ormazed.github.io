# mysql8 일 때 log4jdbc driver 사용


Spring Application 에서 log4jdbc driver 로
mysql8 DB 와 연결을 시도하고 있었다.

톰캣 기동로그에서 아래와 같은 메세지가 계속 확인되었다.
```
Loading class 'com.mysql.jdbc.Driver'. This is deprecated. The nuew driver  class is 'com.mysql.js.jdbc.Drvier'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
```

###확인사항

(1) 어플리케이션 내 com.mysql.jdbc.Driver 를 사용하는 부분이 있는 지 여부 -> 어플리케이션을 undeploy 해버렸는데도 떴다.

(2) 기존에 등록되어 있던 mysql 설정이 남아있는 지 여부 확인 -> grep 때려서 낌세가 보이면 다 주석처리 해버렸다.

(3) log4jdbc 설정을 잘못했나 싶엇서 쥐잡듯이 잡았다. -> 기동로그에 저 메세지가 뜨기는 한데, 어플리케이션 호출에 문제가 없다.

### 해결방법

별짓을 다하다가 불현듯 혹시 사용하고 있는 드라이버에 내용이 있는 게 아닐까라는 신의 계시가 내려왔다.
사용하던 driver 는 `log4jdbc-log4j2-jdbc4.1-1..16.jar`  였다.
해당 jar 파일을 디컴파일 해보니까, `net.sf.log4jdbc.sql.jdbcapi.DriverSpy.class` 라는 파일 내부에 `Properties.isAutoLoadPopularDriverrs()` 에  subDrivers.add() 의 일부로 com.mysql.jdbc.Driver 가 확인되었다.
아하!


