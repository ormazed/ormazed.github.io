package com.example.demo.user.db;

import com.example.demo.db.SimpleDataRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.stereotype.Service;

import javax.lang.model.util.SimpleElementVisitor6;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long>{
    // 왜 여기는 getScore() 가 잡히고 SimpeDataRepositry 에서는 getScore() 가 안 보이는 거지.???
    public List<UserEntity> findAllScoreGreaterThen(int score){
        return this.findAll().stream()
                .filter(it -> {
                    return  it.getScore() >= score;
                }
                ).collect(Collectors.toList());
    }
}