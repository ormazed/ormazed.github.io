package com.example.exception.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public void hello(){
        throw new NumberFormatException("Number Format Exception");
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity numberFormatExceptin(
            NumberFormatException e
    ){
        log.error("RestApiBController",e);
        return ResponseEntity.ok().build();
/*        2024-04-22 20:52:50.999 ERROR 10456 --- [nio-8080-exec-1] c.e.e.contoller.RestApiBController       : RestApiBController

        java.lang.NumberFormatException: Number Format Exception
        at com.example.exception.contoller.RestApiBController.hello(RestApiBController.java:17) ~[main/:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
        at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]*/
    }
}
