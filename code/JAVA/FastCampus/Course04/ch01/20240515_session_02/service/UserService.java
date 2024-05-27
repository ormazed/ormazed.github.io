package com.example.session.service;

import com.example.session.model.LoginRequest;
import com.example.session.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id);
        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();
            if(userDto.getPassword().equals(pw)){
                // 세션에 정보를 저장
                 httpSession.setAttribute("USER", userDto);
            }else{
                throw new RuntimeException("Password 가 일치하지 않습니다.");
            }
        }else{
            throw new RuntimeException("없는 유저입니다.");
        }

    }
}
