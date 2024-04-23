package com.example.exception.exception;

import com.example.exception.contoller.RestApiBController;
import com.example.exception.contoller.RestApiController;
import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
// 여러 개의 컨트롤러 중에서도 모든 예외를 잡아주는 글로벌한 컨트롤러 예외 핸들러이다.
//@RestControllerAdvice(basePackages = "com.example.exception.contoller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
@Order(1)
public class RestApiExceptionHandler {
/* 2024-04-23 GlobalException 을 별도 처리하기 위해 주석 처리하고 GlobalExceptionHandler.java 를 생성

    @ExceptionHandler(value = {Exception.class}) // 모든 Controller 예외를 잡는다
    public ResponseEntity exception(
            Exception e
    ){
        log.error("RestApiExceptionHandler",e);
        return ResponseEntity.status(200).build();
*/

/*
2024-04-22 20:32:00.498 ERROR 11564 --- [nio-8080-exec-1] c.e.e.exception.RestApiExceptionHandler  : RestApiExceptionHandler
        java.lang.IndexOutOfBoundsException: Index: 1 Size: 1
        at java.base/java.util.ImmutableCollections$AbstractImmutableList.outOfBounds(ImmutableCollections.java:333) ~[na:na]
        at java.base/java.util.ImmutableCollections$List12.get(ImmutableCollections.java:585) ~[na:na]

    }
*/
    @ExceptionHandler(value={ IndexOutOfBoundsException.class }) // 특정 Exception 을 처리하겠다고 명시한 상황
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }

    // 2024-04-23
    // ## TEST03 : 존재하지 않는 사용자를 호출할 경우 404 가 반환되도록 예외처리
    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Api> noSuchElement (
            NoSuchElementException e
    ){
        log.error("NoSuchElementException", e);
        var response =  Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
/* 서버는 항상 동일한 형태의 스펙을 제공할 수 있게 된다.
    200 코드일 때 parsing 을 하고 404일때는 굳이 parsing 을 하지 않게 된다
    {
        "result_code": "404",
            "result_message": "Not Found",
            "data": null
    }
*/

}
