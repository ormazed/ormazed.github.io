package com.example.exception.exception;


import com.example.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@Slf4j
@RestControllerAdvice
// GloabalExceptionHandler 는 RestApiException 의 Exception 에 존재하지 않는 예외처리를 해야하기에 가장 마지막으로 동작해야 한다.
// @Order(value = Integer.MAX_VALUE) : default 가 MAX 이다
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> exception(
            Exception e
    ){
        log.error("", e);
        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
                .resultMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    /* 허용하지 않는 Method 를 전달하니까 500 코드로 처리된다 .
    2024-04-23 22:55:00.489 ERROR 7012 --- [nio-8080-exec-3] c.e.e.exception.GlobalExceptionHandler   :
    org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'PUT' not supported
	at org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping.handleNoMatch(RequestMappingInfoHandlerMapping.java:260) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.lookupHandlerMethod(AbstractHandlerMethodMapping.java:442) ~[spring-webmvc-5.3.30.jar:5.3.30]
	at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.getHandlerInternal(AbstractHandlerMethodMapping.java:383) ~[spring-webmvc-5.3.30.jar:5.3.30]
    */
}
