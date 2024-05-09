package com.example.simpleboard.post.service;

import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    public PostEntity create(
            PostRequest postRequest
    ){
       var entity =  PostEntity.builder()
                .boardId(1L) // << 임시 고정
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();
        return postRepository.save(entity);
    }

    // step1 : 게시글이 존재하는 지 여부
    // step2 : 비밀번호가 일치하는 지 여부
    public PostEntity view(PostViewRequest postViewRequest) {
        // status 가 REGISTERED 인 것만 조회하기라서 /all 호출방식에서는 UNREGISTERED 상태도 호출이된다.
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(), "REGISTERED").map(it -> {
            // step2 : 비밀번호가 일치하는 지 여부
            if (!it.getPassword().equals(postViewRequest.getPassword())) {
                var format = "패스워드가 일치하지 않습니다. %s vs %s";

                throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
            }
            return it;
        // step1 : 게시글이 존재하는 지 여부
        }).orElseThrow(() -> {
            return new RuntimeException("해당 게시글이 존재하지 않습니다." + postViewRequest.getPostId());
        });

    }
    public List<PostEntity> all() {
        return postRepository.findAll();
    }

    public void delete(PostViewRequest postViewRequest) {

        postRepository.findById(postViewRequest.getPostId())
            .map(it -> {
                if (!it.getPassword().equals(postViewRequest.getPassword())) {
                    var format = "패스워드가 일치하지 않습니다. %s vs %s";
                    throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                }
            it.setStatus("UNREGISTERED");
            postRepository.save(it);
            return it;

            // step1 : 게시글이 존재하는 지 여부
        }).orElseThrow(() -> {
            return new RuntimeException(postViewRequest.getPostId() + "해당 게시글이 존재하지 않습니다.");
        });

    }
}
