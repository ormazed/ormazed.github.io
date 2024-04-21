package com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // 관련 변수들의 클래스 변수들은 snake case 로 매핑하겠다는 의미임.
public class UserRequest {
    private String userName;
    private Integer userAge;
    private String email;
    private Boolean isKorean;
}
