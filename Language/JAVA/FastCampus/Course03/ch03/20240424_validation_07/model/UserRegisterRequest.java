package com.example.validation.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) //PropertyNamingStrategies.SnakeCaseStrategy.class
public class UserRegisterRequest {
    //@NotBlank // != null && name="" && name=" "
    //@NotEmpty // != null && name=""
    //@NotNull //  != null

    @NotBlank
    private String name;

    @NotBlank
    @Size(min=8, max=13)
    private String password;

    @NotNull // @NotBlank 는 String type 만 사용 가능하다
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지않습니다.") // phone number 와 관련된 정규식 사용
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt; // ISO-8610 에 따른 형식


/*   POST 메서드 방식
    {
        "name" : "다길동",
            "password" : "123456789",
            "age" : 20,
            "email" : "hong@naver.com",
            "phone_number" : "010-2345-0987",
            "register_at" : "2025-11-08T11:44:30.327959"
    }
*/

}
