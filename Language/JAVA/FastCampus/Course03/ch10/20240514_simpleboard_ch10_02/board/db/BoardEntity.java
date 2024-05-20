package com.example.simpleboard.board.db;

import com.example.simpleboard.post.db.PostEntity;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;
    private String status;

    @OneToMany(
            mappedBy = "boardEntity"
    )
    @Where(clause = "status = 'REGISTERED'")
    @Builder.Default
    @org.hibernate.annotations.OrderBy(clause = "id desc")
    private List<PostEntity> postList = List.of();
}