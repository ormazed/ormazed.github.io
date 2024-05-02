package com.example.validation.controller;

import com.example.validation.model.Api;
import com.example.validation.model.UserRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    // Api 를 통해서만 JSON 을 전달할 수 있다.
    //public ResponseEntity<Api<? extends Object>> register(
    // => Api<? extends Object> => java 의 모든 class 는 Object 를 상속받기 때문에 모든 값을 generic 타입으로 리턴할 수 있게 된다.
    // ValidationExceptionHandler 에서 처리하도록 수정
    public Api<? extends Object> register (
            @Valid
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest
                                    // 해당 valid 가 실행되었을 때 해당 결과를 바인딩 리절트에 담는다.
                                   // BindingResult bindingResult

    ){
            log.info("init : {}",userRegisterRequest);
            //if(bindingResult.hasErrors()){ // error 가 존재하는 지 여부 확인 --> ValidationExceptionHandler.java 로 이동
            //}

            var body = userRegisterRequest.getData();
            Api<UserRegisterRequest> response = Api.<UserRegisterRequest>builder()
                    .resultCode(String.valueOf(HttpStatus.OK.value()))
                    .resultMessage(HttpStatus.OK.getReasonPhrase())
                    .data(body)
                    .build();
            return response;
    }
}
