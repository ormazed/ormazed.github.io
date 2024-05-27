package com.example.validation.controller;

import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRegisterRequest register(

            @Valid
            @RequestBody
            UserRegisterRequest userRegisterRequest
    ){
            log.info("init : {}",userRegisterRequest);
            return userRegisterRequest;
    }
}
