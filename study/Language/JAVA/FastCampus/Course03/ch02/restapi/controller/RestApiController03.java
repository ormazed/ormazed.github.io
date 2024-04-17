package com.example.restapi.controller;

import com.example.restapi.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

// Get 방식은 Path Variable 하다 => 경로에서 특정한 정보를 넣어서 호출이 가능하며 해당 정보는 변경될 수 있다
/*
Query Parameter : 특정 정보에 필터링을 걸때 사용한다.
        > 주소 뒤에 '?' 로 시작한 이후를 Query 파라미터라고 부른다
*/

@RestController // REST API Controller 기능을 하는 특정한 클래스를 지정하기 위한 어노테이션이다
@RequestMapping("/api")
public class RestApiController03 {
    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(
            @PathVariable(name = "message") String msg,
            // Integer != int --> Interger 는 null 할당이 가능하고 int 는 null 할당이 불사하고 기본은 0 이다
            // 주소는 null 이 들어갈 수 없으니 Integer 보다는 int 가 더 적합하다
            @PathVariable int age,
            @PathVariable boolean isMan
    ){
        System.out.println("echo message " + msg);
        System.out.println("echo age " + age);
        System.out.println("echo isMan " + isMan);
        return msg;
    }

    // 테스트 URL : //http://localhost:8080/api/book/parsing1?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    // parsing1
    @GetMapping(path = "/book/parsing1")
    public void queryParam(
            @RequestParam String category,
            @RequestParam int issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") int issuedDay
    ){
        System.out.println("echo category " + category);
        System.out.println("echo issuedYear " + issuedYear);
        System.out.println("echo issuedMonth " + issuedMonth);
        System.out.println("echo issuedDay " + issuedDay);
    }


    // parsing2
    @GetMapping(path = "/book/parsing2")
    public void queryParamDto(
            BookQueryParam bookQueryParam
    ){
        System.out.println("echo bookQueryParam " + bookQueryParam);
        // 호출 URL1 : //http://localhost:8080/api/book/parsing2?category=IT&issuedYear=2023&issued-month=01&issued_day=31
        // 결과1 : echo bookQueryParam BookQueryParam(category=IT, issuedYear=2023, issuedMonth=null, issuedDay=0)
        // > issedMonth 와 inssued_day 의 경우 객체명이 불일치하기 때문에 각각 null 과 0 이 반환되었다.
        // > 전체 변수명에 대한 규칙이 필요한 이유

        // 호출 URL2 : http://localhost:8080/api/book/parsing2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
        // 결과2 : echo bookQueryParam BookQueryParam(category=IT, issuedYear=2023, issuedMonth=01, issuedDay=31)
    }

    // todo1 : int 형 파라미터 2개를 전달받는다 => 덧셈/곱셈을 실행하고 queryParameter 로 파싱
    // http://localhost:8080/api/todo1?num1=40&num2=30
    @GetMapping(path = "/todo1")
    public void todo1(
            @RequestParam int num1, // 40
            @RequestParam int num2 // 40
    ){
        int sum = num1 + num2;
        int mul = num1 * num2;
        System.out.println("sum = " + sum );
        System.out.println("mul = " + mul );
        //System.out.println(num1);
        //System.out.println(num2);
    }
}
