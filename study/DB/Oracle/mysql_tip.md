### UPDATE 명령어 실행 시 발생
```
12:48:23	UPDATE `user` SET  age = 20, email = 'gang@gmail.com' WHERE  name = '강감찬'
Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.
To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.	0.000 sec
```
원인 : 삭제/수정을 하고자 한다면 KEY 열을 WHERE 조건으로 사용했을 때만 가능하도록 하는 것   
=> 나같은 경우는 ID 를 PRIMARY KEY 로 했으니까 WHERE ID='2' 뭐 이런식으로 했다면 발생하지 않았을 것이다.

```
set sql_safe_updates=0;
```
UPDATE 명령어를 실행하기 전에 위의 SQL 문을 추가한 상태로 실행하게 되면 일시적으로 해당 모드를 해제하고 사용할 수 있게 된다.   


### DROP vs TRUNCATE
- DROP : DB 시스템에서 테이블 자체를 삭제하는 것
- TRUNCATE : 테이블 내의 데이터만 삭제하는 것
