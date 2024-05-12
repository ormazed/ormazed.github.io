package com.example.simpleboard.post.service;

import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.common.Api;
import com.example.simpleboard.common.Pagination;
import com.example.simpleboard.post.db.PostEntity;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.post.model.PostRequest;
import com.example.simpleboard.post.model.PostViewRequest;
import com.example.simpleboard.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;

    public PostEntity create(
            PostRequest postRequest
    ){
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();

       var entity =  PostEntity.builder()
                .boardEntity(boardEntity) //기존 : boardId(1L)  << boardId 를 1로 고정
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
            // 관리자 계정에서 달아둔 회신도 확인할 수 있도록 함.
            // var replyList = replyService.findAllByPostId(it.getId()); //  ;; PostEntity 가 OneToMany 관계가 되었기 때문에 작성 필요X
            //it.setReplyList(replyList); // PostEntity 에 선언되어 있음. ;; PostEntity 가 OneToMany 관계가 되었기 때문에 작성 필요X
            return it;

        // step1 : 게시글이 존재하는 지 여부
        }).orElseThrow(() -> {
            return new RuntimeException("해당 게시글이 존재하지 않습니다." + postViewRequest.getPostId());
        });



    }
    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalElements(list.getTotalElements())
                .totalPage(list.getTotalPages())
                .build()
                ;
        var response = Api.<List<PostEntity>>builder()
                .body(list.toList())
                .pagination(pagination)
                .build();
        return response;
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
