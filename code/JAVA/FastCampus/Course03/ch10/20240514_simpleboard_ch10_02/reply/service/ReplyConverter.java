package com.example.simpleboard.reply.service;

import com.example.simpleboard.crud.Converter;
import com.example.simpleboard.post.db.PostRepository;
import com.example.simpleboard.reply.db.ReplyEntity;
import com.example.simpleboard.reply.model.ReplyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyConverter implements Converter<ReplyDto, ReplyEntity>{

    private final PostRepository postRepository;
    @Override
    public ReplyDto toDTO(ReplyEntity replyEntity) {

       return ReplyDto.builder()
                .id(replyEntity.getId())
                .postId(replyEntity.getId())
                .userName(replyEntity.getUserName())
                .password(replyEntity.getPassword())
                .status(replyEntity.getStatus())
                .title(replyEntity.getTitle())
                .content(replyEntity.getContent())
                .repliedAt(replyEntity.getRepliedAt())
                .build();
    }

    @Override
    public ReplyEntity toEntity(ReplyDto replyDto) {
        var postEntity = postRepository.findById(replyDto.getPostId());
        return ReplyEntity.builder()
                .id(replyDto.getId()) // null => save(), !null => update()
                .post(postEntity.map(
                        it -> {
                            return it;
                        })
                        .orElseGet(
                                () -> null
                        ))
                .userName(replyDto.getUserName())
                .password(replyDto.getPassword())
                .status(replyDto.getStatus())
                .title(replyDto.getTitle())
                .content(replyDto.getContent())
                .repliedAt(replyDto.getRepliedAt())
                .build();
    }
}
