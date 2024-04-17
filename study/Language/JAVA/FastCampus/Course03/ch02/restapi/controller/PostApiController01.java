package com.example.restapi.controller;

import com.example.restapi.model.BookRequest;
import com.example.restapi.model.RequestBodyTodo01;
import com.example.restapi.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController01 {
    // 호출URL : http://localhost:8080/api/post
    // SCHEME :// HOST [ ":" PORT ] [ PATH [ "?" QUERY ]]

    @PostMapping("/post")
    // POST 방식 = HTTP Header + HTTP Body
    //> GET 방식의 경우 URL 에 데이터가 노출되기 때문에 보안이 중요한 데이터를 전달하기에는 적합하지 않다
    //> POST 방식의 body 에 데이터를 추가하여 전달 > HTML, JSON, XML, TEXT 등 Format 으로 가능

    public String post(

            // POST 통신은 Get 과 달리 기본 통신 방식이 객체를 통해 이루어진다
            // @RequestBodyTodo01 : Post/PUT 방식에서 HTTP Body 로 들어오는 데이터를 해당 객체에다가 데이터 클래스에 매핑한다는 의미
            @RequestBody BookRequest bookRequest
    ){
        System.out.println(bookRequest);
        return bookRequest.toString();
    }

    // TODO1 : RequestBodyTodo01 로 사용자의 이름, 전화번호, 이메일을 받는 POST Method 생성
    // 호출URL : http://localhost:8080/api/post/todo01
    @PostMapping("/post/todo01")
    public RequestBodyTodo01 post_todo01(
            // POST 통신은 Get 과 달리 기본 통신 방식이 객체를 통해 이루어진다
            // @RequestBodyTodo01 : Post/PUT 방식에서 HTTP Body 로 들어오는 데이터를 해당 객체에다가 데이터 클래스에 매핑한다는 의미
            @RequestBody RequestBodyTodo01 requestBody
    ){
        System.out.println(requestBody);
        return requestBody;
    }

    @PostMapping("/user")
    public UserRequest userRequest(
            // POST 통신은 Get 과 달리 기본 통신 방식이 객체를 통해 이루어진다
            // @RequestBodyTodo01 : Post/PUT 방식에서 HTTP Body 로 들어오는 데이터를 해당 객체에다가 데이터 클래스에 매핑한다는 의미
            @RequestBody
            UserRequest userRequest
    ){
        System.out.println(userRequest);
        return userRequest;
    }
}

/* JSON 형태 =>  key:value
*  전달가능한 format : String, Number, boolean, {}, []
* * return 타입에 따라 반환되는 방식이 달라진다.
 * (1) void => No Content
 * (2) String +  return bookRequest.toString(); => BookRequest(name=Spring Boot - POST, number=100, category=JAVA)
 * (3) BookRequest + return bookRequest;
 *       {
 *          "name":"Spring Boot(POST)",
 *          "number": "100",
 *          "category":"JAVA"
 *        }

*
* */