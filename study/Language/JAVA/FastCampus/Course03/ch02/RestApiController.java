package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // REST API Controller 기능을 하는 특정한 클래스를 지정하기 위한 어노테이션이다
@RequestMapping("/api")
public class RestApiController {

    // Spring boot 는 모든 동작을 어노테이션을 기반하여 동작하도록 작성되어 있다.
    // 클라이언트의 요청에 대한 응답은 문자열로 이루어져 있으며, 이 응답 문자열을 꾸미는 것은 브라우저가 수행한다.
    @GetMapping(path = "/hello") // Get 방식으로 요청이 전달됨
    public String hello(){
        // 요청에 대한 응답은 html 로 반환된다.
        var html = "<html><body><h1>Hello World return : html </h1></body></html>";

        return html;
    }
}
