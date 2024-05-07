package com.example.demo.user.controller;

import com.example.demo.user.model.UserEntity;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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


    @GetMapping("/score")
    public List<UserEntity> filterScore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }

    @GetMapping("/range")
    public List<UserEntity> filterScoreRange(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.filterScore(min, max);
    }

    // Delete
    @DeleteMapping("/id/{id}")
    public void delete(
            @PathVariable Long id
    ){
        //userService.delete(id);
    }

}