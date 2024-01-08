# BasicDataSourceFactory 정리
## org.apache.tomccat.dbcp.dbcp2.BasicDataSourceFactory



### DataSourceFactory vs BasicDataSourceFactory

#### DataSourceFactory

#### BasicDataSourceFactory


---

## 추가
### defaultAutoCommit 설정
Tomcat 의 server.xml 내 <Resource> 지시어에 `defaultAutoCommit` 설정이 있다.

> defaultAutoCommit 



### tomcat 의 factory 란 무엇인가


### tomcat connection pool
기존의 Tomcat JDBC Pool 은 commons-dbcp 였으나
Tomcat7 부터 dbcp2 로 바뀌었다.   

> `commons-dbcp`   
1. 싱글 스레드로 생성 -> 쿼리가 동작하는 동안 모든 풀을 잠궈서 안전하게 처리될 수 있도록 하기 위함.
... docs 참고

> `dbcp2`




#### volatile 이란

