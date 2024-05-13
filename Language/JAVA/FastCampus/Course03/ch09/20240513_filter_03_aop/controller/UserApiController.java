package com.example.filter.controller;

import com.example.filter.interceptor.OpenApi;
import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
//@OpenApi
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {
    @PostMapping("")
    @OpenApi
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}", userRequest);
        throw new NumberFormatException(""); // TimerAop 내 @AfterThrowing 을 테스트하기 위함
        //return userRequest;
    }

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

}

