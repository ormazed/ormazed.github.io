package com.example.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteApiController {

    //@DeleteMapping("/delete")

    // path 를 입력하면 여러 주소를 넣어줄 수 있다.
    // 삭제를 위해 특정 user 의 이름(userName)을 받는다고 가정
    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
        }
    )
    public void delete(
      @PathVariable String userName
    ){
        log.info("user-name : {}", userName);
    }
}
