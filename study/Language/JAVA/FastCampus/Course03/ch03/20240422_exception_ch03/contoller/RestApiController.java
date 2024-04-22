package com.example.exception.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping(path = "")
    public void hello(){
        // #TEST01
        // throw new RuntimeException("Runtime Exception call");

        // #TEST02 : java.lang.IndexOutOfBoundsException: Index: 1 Size: 1
        var list = List.of("hello");
        var element = list.get(1);
        log.info("element : {}" , element);

    }
}
