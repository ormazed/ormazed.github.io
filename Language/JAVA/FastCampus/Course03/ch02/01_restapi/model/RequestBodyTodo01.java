package ch02.com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// TODO1 : RequestBodyTodo01 로 사용자의 이름, 전화번호, 이메일을 받는 POST Method 생성
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyTodo01 {
    private String name;
    private String phone;
    private String email;
}
