package com.example.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
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
