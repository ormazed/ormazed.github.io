package org.delivery.db.userorder.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserOrderStatus {

    REGISTERED("등록"),
    UNREGISTERED("해지"),
    ORDER("배달의민족 주문~"),

    ACCEPT("주문확인"),

    COOKING("조리시작"),

    DELIVERY("배달중"),

    RECEIVE("배달완료")
    ;


    private String description;
}
