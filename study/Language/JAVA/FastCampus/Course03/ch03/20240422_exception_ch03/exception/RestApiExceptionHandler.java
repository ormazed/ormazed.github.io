package com.example.exception.exception;

import com.example.exception.contoller.RestApiBController;
import com.example.exception.contoller.RestApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
// 여러 개의 컨트롤러 중에서도 모든 예외를 잡아주는 글로벌한 컨트롤러 예외 핸들러이다.
//@RestControllerAdvice(basePackages = "com.example.exception.contoller")
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})

public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class}) // 모든 Controller 예외를 잡는다
    public ResponseEntity exception(
            Exception e
    ){
        log.error("RestApiExceptionHandler",e);
        return ResponseEntity.status(200).build();

/*
2024-04-22 20:32:00.498 ERROR 11564 --- [nio-8080-exec-1] c.e.e.exception.RestApiExceptionHandler  : RestApiExceptionHandler
        java.lang.IndexOutOfBoundsException: Index: 1 Size: 1
        at java.base/java.util.ImmutableCollections$AbstractImmutableList.outOfBounds(ImmutableCollections.java:333) ~[na:na]
        at java.base/java.util.ImmutableCollections$List12.get(ImmutableCollections.java:585) ~[na:na]
        */
    }

    @ExceptionHandler(value={ IndexOutOfBoundsException.class }) // 특정 Exception 을 처리하겠다고 명시한 상황
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ){
        log.error("IndexOutOfBoundsException", e);
        return ResponseEntity.status(200).build();
    }
}
