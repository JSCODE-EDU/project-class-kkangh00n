package com.jscode.board.domain;

import com.jscode.board.domain.common.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    //Builder 패턴
//    private Post(Builder builder){
//        this.title = builder.title;
//        this.content = builder.content;
//    }
//
//    @NoArgsConstructor
//    public static class Builder{
//        private String title;
//        private String content;
//
//        public Builder title(String title){
//            this.title = title;
//            return this;
//        }
//        public Builder content(String content){
//            this.content = content;
//            return this;
//        }
//        public Post build(){
//            return new Post(this);
//        }
//    }

    //엔티티에 업데이트 기능 이동
    public void updatePost(String title, String content){
        this.title = title;
        this.content = content;
    }
}
