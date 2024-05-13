package com.example.validation.model;


import com.example.validation.annotation.AnswerYearMonth;
import com.example.validation.annotation.MyYearMonth;
import com.example.validation.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) //PropertyNamingStrategies.SnakeCaseStrategy.class
public class UserRegisterRequest {
// 2024-05-03_validation_03 : 조건이 여러가지일 때의 처리방법
    //@NotBlank
    private String name;
    private String nickName;

    @NotBlank
    @Size(min=1, max=13)
    private String password;

    @NotNull // @NotBlank 는 String type 만 사용 가능하다
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지않습니다.") => PhoneNumber.java 로 이관
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt; // ISO-8610 에 따른 형식

    //@MyYearMonth
   // private String mytest;

    @AnswerYearMonth(pattern = "yyyy-MM")
    private String birthDayYearMonth;

    // name 이나 nickName 이 존재하면 정상처리
    @AssertTrue( message = "name 과 nickName 은 필수값입니다. ") // 'is' 라는 이름을 가진 boolean 형에 동작
    public boolean isNameCheck(){
        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }

        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }

        return false;
    }
}
