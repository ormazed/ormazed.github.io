package com.example.exception.contoller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
    // ## TEST01 :
    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                        .id("1")
                        .age(10)
                        .name("가길동")
                        .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(20)
                    .name("나길동")
                    .build()
    );
    // localhost:8080/api/user/id/{userId}
    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ){
        var user = userList.stream()
                .filter(
                        it -> it.getId().equals(userId)
                )
                .findFirst()
                .get(); //.isPresent();

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();
        return response;
    }
/*
 ## TEST01 : 바깥쪽(result_code/result_message/data) 에 기본 베이스가 data 부분에 특별한 데이터들이 추가로 들어있는 형태가 가능
{
    "result_code": "200",
    "result_message": "OK",
    "data": {
        "id": "1",
        "name": "가길동",
        "age": 10
    }
}
// TEST02 : 99번 id 를 호출할 경우 예외가 발생하나 200 코드가 반환되고 있음 -> TEST03
java.util.NoSuchElementException: No value present
	at java.base/java.util.Optional.get(Optional.java:143) ~[na:na]
	at com.example.exception.contoller.UserApiController.getUser(UserApiController.java:41) ~[main/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
*/

}
