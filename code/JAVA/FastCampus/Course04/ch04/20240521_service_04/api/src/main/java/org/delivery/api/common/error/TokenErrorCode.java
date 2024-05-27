package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
/*
 * Token관련 에러코드의 경우 2000번대를 사용
*/

@Getter
@AllArgsConstructor
public enum TokenErrorCode implements ErrorCodeIfs{
    INVALID_TOKEN(400, 2000, "유효하지 않는 토큰."),
    EXPIRED_TOKEN(400, 2001, "만료된 토큰."),
    TOKEN_EXCEPTION(400, 2002, "알 수 없는 토큰")
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;
}
