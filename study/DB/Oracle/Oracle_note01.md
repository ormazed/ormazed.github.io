#  SetAutoCommit() 메서드 관련 테스트


## Coludnot commit with auto-commit set on
> `This is an intentional change in the Oracle JDBC driver 12c to support the JDBC specification`   

* throw SQLException when Connection.commit() / Connecction.rollback() is invoked when auto-commit is true   
* auto-comiit 이 true 일 때  Connection.commit() / Connection.rollback() 이 동작하게 될 경우 발생한다.   

(sol)
> `-Doracle.jdbc.autoCommitSpecCompliant=false`
   


---
### 추가
#### createStatement vs preparedStatement
##### createStatement    
DB 에는 Optimizer 가 있어서 세션에서 읽어들이는 sql 에 대해 dictionary view 를 거쳐 sql 을 실행하고 계획을 세운 뒤 실행하게 된ㄴ다.

// 내용추가는 naver blog 두 주먹 불끈 쥐고 일어나 참고 


##### preparedStatement

