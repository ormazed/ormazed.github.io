package org.delivery.api.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AccountApiController {

    private final AccountRepository accountRepository;
    @GetMapping("/me")
    public Api<AccountMeResponse> save(){
        var response = AccountMeResponse.builder()
                .name("가길동")
                .email("hong@email.com")
                .registeredAt(LocalDateTime.now())
                .build();

        // Error 발생 케이스 : str 로 작성된 내용을 Inger 에 입력
        var str = "안녕하세요";
        var age = 0;

        try {
            Integer.parseInt(str);
        }catch (Exception e){
            throw new ApiException(ErrorCode.SERVER_ERROR, e, "사용자 me 호출 시 에러발생");
        }
        return Api.OK(response);
        // return Api.ERROR(UserErrorCode.USER_NOT_FOUND, "가길동을 찾을 수 없습니다.");
        // {"email":"hong@email.com","name":"가길동","registeredAt":"2024-05-17T22:03:10.8865166"}
    }
}
