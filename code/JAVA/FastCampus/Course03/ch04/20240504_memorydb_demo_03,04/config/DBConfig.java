/*package com.example.demo.config;

import com.example.demo.user.db.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration*/
/*
(1) Spring Application 이 동작할 떄
(2) configuration 을 찾아서
(3) 특정한 내용을 spring context 라는 영역에다가 new 생성자를 통해 객체를 생성한다.
(4) 각 영역(MVC, Bean)들 사이에서 필요한 내용이 있다면 알아서 주입하게 된다.
*/
/* // 수정이 불가능한 외부 클래스를 사용할 때 사용하는 방법
public class DBConfig {

    @Bean
    public UserRepository userRepository(){
        return new UserRepository();
    }
}
*/
