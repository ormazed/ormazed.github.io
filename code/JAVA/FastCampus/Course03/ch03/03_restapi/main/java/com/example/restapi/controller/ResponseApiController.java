package com.example.restapi.controller;

import com.example.restapi.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // REST API 를 통해 응답값이 json 으로 고정됨(테스트1,2,3)
//@Controller //  응답값이 html 으로 고정됨(테스트4)
@RequestMapping("/api/v1")
public class ResponseApiController { // 호출URL :  http://localhost:8080/api/v1
    /*   // 테스트1 : Object 방식
    @GetMapping("") // 일반적인 사용방법
    public UserRequest user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(20);
        user.setEmail("hong@hmail.com");

        return user;
    }*/

}
