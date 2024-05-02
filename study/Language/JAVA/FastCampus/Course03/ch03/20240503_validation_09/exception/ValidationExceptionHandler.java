package com.example.validation.exception;

import com.example.validation.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ValidationExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api>  validationException(
            MethodArgumentNotValidException exception
    ){
        log.error("", exception);

        var errorMessageList = exception.getFieldErrors().stream()
                .map( it -> {
                    var format = "%s : { %s } 은 %s";
                    var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());
                    return message;
                }).collect(Collectors.toList());
        var error = Api.Error
                .builder()
                .errorMessage(errorMessageList)
                .build();

        var errorResponse = Api
                .builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error(error)
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);
    }
}

/* UserApiController 에서는 비즈니스 로직만 처리하게 되고
예외에 대해서는 전적으로 ValidationExceptionHandler 에서 처리하도록 한다.
=> UserApiController 에서 처리된 내용은 반드시 유효하다는 것이 보장된다.
=> 비즈니스 로직을 해치는 검증과정을 UserApiController 에서 처리할 필요가 없어진다
* */