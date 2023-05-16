package com.jscode.board.domain;

import com.jscode.board.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    //엔티티에 업데이트 기능 이동
    public void updatePost(String title, String content){
        this.title = title;
        this.content = content;
    }
}
