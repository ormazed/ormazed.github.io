package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import com.example.cookie.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();
        var optionalUser = userRepository.findByName(id);
        // db 에 저장될 때의 id 와 사용자가 입력하는 id 개념이 있는데 여기는 사용자가 입력하는 ID 정보

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();
            if(userDto.getPassword().equals(pw)){
                // cookie 에 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setMaxAge(-1);
                cookie.setHttpOnly(true);
                //cookie.setSecure(true);
                httpServletResponse.addCookie(cookie);

            }
        }else{
            throw new RuntimeException("존재하지 않는 계정정보입니다.");
        }
    }

/*    // 테스트 삼아 만들어봤는데..
    public UserDto getUserById(String userId){
        Optional<UserDto> optionalUser = userRepository.findById(userId);
        return optionalUser.orElse(null);
    }*/
}
