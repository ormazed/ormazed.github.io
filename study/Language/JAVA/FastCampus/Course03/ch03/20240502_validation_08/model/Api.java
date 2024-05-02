package com.example.validation.model;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @NoArgsConstructor, @AllArgsConstructor 한 번에 대체해준다
@NoArgsConstructor
@AllArgsConstructor
@Builder // 해당 클래스에 대한 빌더(builder) 클래스가 자동으로 생성되어 객체를 생성할 때 사용할 수 있습니다. 이를 통해 객체를 생성하는 동안 메서드 체이닝(method chaining)을 사용하여 각 필드의 값을 설정할 수 있습니다
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Api<T> {
    @Valid
    private T data;
    private String resultCode;
    private String resultMessage;
    private Error error;

    // inner class 생성
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class Error{
        // Error Msg
        private List<String> errorMessage;

     }
}
