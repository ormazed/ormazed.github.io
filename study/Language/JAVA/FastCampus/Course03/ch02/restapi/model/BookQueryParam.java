package com.example.restapi.model;

import lombok.*;

@Data
@AllArgsConstructor // 전체 파라미터를 가진 생성자 생성
@NoArgsConstructor // 아무런 파라미터를 받지 않는 기본 생성자 생성
// lombok 을 사용하면 generate Constructor/Getter-Setter 하지 않아도 자동으로 생성된다
public class BookQueryParam {
    private String category;
    private int issuedYear;
    private String issuedMonth;
    private int issuedDay;
}
