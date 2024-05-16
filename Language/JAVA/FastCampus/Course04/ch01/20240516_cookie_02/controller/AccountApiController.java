package com.example.cookie.controller;

import com.example.cookie.model.LoginRequest;
import com.example.cookie.model.UserDto;
import com.example.cookie.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final UserService userService;
    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse

    ){
        userService.login(loginRequest, httpServletResponse);
    }
/*    // 테스트 삼아 만들어봤는데..
    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest request
    ){
        // 세션에서 사용자 ID 가져오기
        HttpSession userObject = request.getSession(false);
        if (userObject != null && userObject.getAttribute("userId") != null) {
            String userId = (String) userObject.getAttribute("userId");

            // 사용자 서비스를 사용하여 사용자 정보 가져오기
            return userService.getUserById(userId);
        } else {
            // 세션이 없거나 사용자 ID가 없는 경우
            return null;
        }
    }*/

}
