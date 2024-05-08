package com.example.simpleboard.board.service;

import com.example.simpleboard.board.db.BoardEntity;
import com.example.simpleboard.board.db.BoardRepository;
import com.example.simpleboard.board.model.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    // final 이 붙어야지 Argument, 즉 기본 생성자에 해당 값이 들어가서 생성이 된다.
    // final 은 생성자에서 초기화 되어야 하기 때문이다.

    public BoardEntity create(
            BoardRequest boardRequest
    ){
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();
        return boardRepository.save(entity);
    }

}
