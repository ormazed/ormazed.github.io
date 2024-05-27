package com.example.filter.controller;

import com.example.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    /*
    @PostMapping("")
    public void register(
        @RequestBody
        UserRequest userRequest
    ){
        log.info("{}", userRequest);
        // 일부 데이터의 Mapping 문제가 발생한다.
        // 결과 : UserRequest(name=홍길동, phoneNumber=null, email=hong@email.com, age=44)
    }*/

/*  // 방법1 :
    // 결과 : c.e.filter.controller.UserApiController  : {name=홍길동, phoneNumber=010-1111-2222, email=hong@email.com, age=44}
    // => 임시로 확인하는 방법; HttpEntity 로 한번 더 casting 해야하는 문제가 발생한다.
    @PostMapping("")
    public void register(
        HttpEntity http
    ){
        log.info("{}", http.getBody());
    }*/

    // 방법2
    // 결과 :  c.e.filter.controller.UserApiController  : UserRequest(name=홍길동, phoneNumber=null, email=hong@email.com, age=44)
    // => 정확하게 데이터를 받아왔는지 확인하기 힘들다.
    @PostMapping("")
    public UserRequest register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}", userRequest);
        return userRequest;
    }
}

