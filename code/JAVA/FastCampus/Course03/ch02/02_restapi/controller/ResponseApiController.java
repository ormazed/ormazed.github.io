package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // REST API 를 통해 응답값이 json 으로 고정됨(테스트1,2,3)
//@Controller //  응답값이 html 으로 고정됨(테스트4)
@RequestMapping("/api/v1")
public class ResponseApiController { // 호출URL :  http://localhost:8080/api/v1
    /*   */// 테스트1 : Object 방식
        @GetMapping("") // 일반적인 사용방법
        public UserRequest user(){
            var user = new UserRequest();
            user.setUserName("홍길동");
            user.setUserAge(20);
            user.setEmail("hong@hmail.com");

            return user;
            // Object class 를 return 하게 되면 해당 클래스의 내용을 스프링부타가 알아서 JSON 으로 바꿔서 응답 = class 의 내용과 동일
            // => @JsonNaming 에 따라서 값이 달라지도록 되어 있다.
        }

  /*       // 테스트2 : String 방식
        // 결과 : UserRequest(userName=홍길동, userAge=20, email=hong@hmail.com, isKorean=null)
        @GetMapping("")
        public String user(){
            var user = new UserRequest();
            user.setUserName("홍길동");
            user.setUserAge(20);
            user.setEmail("hong@hmail.com");

            log.info("user : {}", user); // user : UserRequest(userName=홍길동, userAge=20, email=hong@hmail.com, isKorean=null)
            return user.toString();
        }
*/
/*   // 테스트3 : ResponseEntity 방식
    @GetMapping("")
    public ResponseEntity<UserRequest> user() {
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("hong@hmail.com");

        log.info("user : {}", user);

        var response = ResponseEntity
                .status(HttpStatus.CREATED) // 반환되는 HTTP Status code 를 조작할 수 있다.
                .header("domainName","fastcampus.co.kr") // Header 커스텀 가능
                .body(user);

        return response;
    }
*/
/*    // 테스트4 : 주로 Exception 발생에대한 코드처리 시 활용한다.
    @GetMapping(path = "")
    @ResponseBody // 어노테이션이 활성화 상태일 때는 문제x -> 주석상태라면? 404
    public UserRequest user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("hong@hmail.com");

        log.info("user : {}", user);

        var response = ResponseEntity
                .status(HttpStatus.OK) // 반환되는 HTTP Status code 를 조작할 수 있다.
                .header("domainName","fastcampus.co.kr") // Header 커스텀 가능
                .body(user);

        return user;
    }*/
}
