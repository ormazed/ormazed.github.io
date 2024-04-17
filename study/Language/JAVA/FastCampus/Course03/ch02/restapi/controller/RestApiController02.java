/*
package com.example.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Get 방식은 Path Variable 하다 => 경로에서 특정한 정보를 넣어서 호출이 가능하며 해당 정보는 변경될 수 있다
@RestController // REST API Controller 기능을 하는 특정한 클래스를 지정하기 위한 어노테이션이다
@RequestMapping("/api")
public class RestApiController02 {

    // Spring boot 는 모든 동작을 어노테이션을 기반하여 동작하도록 작성되어 있다.
    // 클라이언트의 요청에 대한 응답은 문자열로 이루어져 있으며, 이 응답 문자열을 꾸미는 것은 브라우저가 수행한다.
    @GetMapping(path = "/hello") // Get 방식으로 요청이 전달됨
    public String hello(){
        // 요청에 대한 응답은 html 로 반환된다.
        var html = "<html><body><h1>Hello World return : html </h1></body></html>";

        return html;
    }

    @GetMapping(path = "/echo/{message}")
    public String echo(
            // 테스트1 : @PathVariable String messge
            // 테스트2
            @PathVariable(name = "message") String msg
    ){
        System.out.println("echo message " + msg);
        // 테스트3 : 소문자로 호출 시 대소문자 반환
        // return msg.toUpperCase();

        // 테스트4 : 인코딩 > 윈도우 서버의 경우 기본적으로 인코딩이 ms949 이다 -> web :     utf8 로 호출 시 깨짐 발생
        return msg;
    }
}
*/