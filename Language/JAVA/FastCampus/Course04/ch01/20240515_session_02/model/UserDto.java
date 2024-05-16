package com.example.session.model;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String password;

}
