package ch02.com.example.restapi.controller;

import ch02.com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j // system.out 으로 log 를 출력하는 게 아닌 log.info() 라는 메서드를 통해 관리
@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put") // POST 와 PUT 은 유사하나, 이미 데이터가 입려된 상태라면 UPDATE 를 치는게 PUT 메서드이다.
    public void put(
        @RequestBody
        UserRequest userRequest
    ){
        log.info("Request : {}", userRequest);
        // log.info() => 2024-04-17T21:43:09.359+09:00  INFO 18024 --- [rest-api] [nio-8080-exec-1] c.e.restapi.controller.PutApiController  :
        //                Request : UserRequest(userName=홍길동, userAge=78, email=leedo@test.com, isKorean=false)
        // ("Request : {}", userRequest) => 중괄호의 내용은 뒤에 있는 객체가 매핑되고 toString 이 호출된다.
    }
}
/* System.out. 과 log.info() 의 차이
System.out : System.out 이 실행이 되고 해당 다음 메서드가 호출되는 방식 => 처리속도에 영향을 미칠 수 있음
log.info() : buffer 를 가지고 있기 때문에 해당 버퍼의 내용을 담고 바로 다음 메서드를 동작할 수 있도록 리턴이 가능하다. => 상대적으로 성능에 영향을 덜 미친다.
* */
