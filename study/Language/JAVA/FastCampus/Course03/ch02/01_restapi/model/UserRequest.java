package ch02.com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class) // 관련 변수들의 클래스 변수들은 snake case 로 매핑하겠다는 의미임.
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private String userName; // user_name
    private Integer userAge;  // user_age
    private String email;
    private Boolean isKorean; // boolean 의 기본값은 false 이다.
    // isKorean 이 매칭되지 않은 이유
    // => lombok 데이터 클래스의 structure 를 보면 primitive type 은 set isKorean 이 아니라 setKorean 으로 만들어지기 때문이다
    // is_korean -> korean  or boolean => Boolean 으로 변경 후 작업하면 실제 값이 매칭된다.
}
