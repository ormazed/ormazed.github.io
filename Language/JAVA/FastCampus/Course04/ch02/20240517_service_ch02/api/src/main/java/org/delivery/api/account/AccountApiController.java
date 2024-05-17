package org.delivery.api.account;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.RequiredArgsConstructor;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.db.account.AccountEntity;
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
    public AccountMeResponse save(){
        return AccountMeResponse.builder()
                .name("가길동")
                .email("hong@email.com")
                .registeredAt(LocalDateTime.now())
                .build();
        // {"email":"hong@email.com","name":"가길동","registeredAt":"2024-05-17T22:03:10.8865166"}
    }
}
