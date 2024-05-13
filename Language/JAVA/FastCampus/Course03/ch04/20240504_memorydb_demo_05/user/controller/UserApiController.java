package com.example.demo.user.controller;

import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/* Controller 은 Service 에게 요청을 전달하게 되고
Service 는 비즈니스 로직에 의해 Repository 내 데이터를 처리한 후
response 가 전달된다/
* */
// @Controller // HTTP Request 가 들어오는 내용을 처리하고 Response 를 처리하는 영역임을 선언하는 어노테이션
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    // Create, Update
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ){
        return userService.save(userEntity);
    }

    // Read
    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @GetMapping(path = "/id/{id}")
    public UserEntity findOne(
            @PathVariable Long id
    ){
        var response = userService.findById(id);
        return response.get(); // null 값이 return 될 수 있도록 함
    }

/*
    // @PathVariable 로 score 처리
    @GetMapping(path = "/score/{score}")
    public  List<UserEntity>  filterScore(
            @PathVariable int score
    ){
        return userService.filterScore(score);
    }*/

    // @RequestParam 로 score 처리
    @GetMapping(path = "/score")
    public  List<UserEntity>  filterScore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }

    // Delete
    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        userService.delete(id);
    }

}