package com.example.session.db;

import com.example.session.model.UserDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository {

    private List<UserDto> userList = new ArrayList<>();

    @PostConstruct
    public void init(){
        userList.add( new UserDto("가길동", "1234"));
        userList.add( new UserDto("나길동", "1234"));
        userList.add( new UserDto("다길동", "1234"));
        userList.add( new UserDto("라길동", "1234"));
    }

    public Optional<UserDto> findByName(String name){
        return userList.stream().filter(it -> {
            return it.getName().equals(name);
        }).findFirst();  // 조건에 충족하는 정보가 있을 경우 첫번째 값을 찾아서 반환한다.
    }
}
