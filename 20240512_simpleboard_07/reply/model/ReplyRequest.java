package com.example.simpleboard.reply.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ReplyRequest {// 질문 게시글에 대한 답변 게시글을 작성하는 방식

    @NotNull
    @Id
    private Long postId;

    @NotBlank
    private String userName; // 관리자 계정

    @NotBlank
    @Size(min=4, max=4)
    private String password;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

}
