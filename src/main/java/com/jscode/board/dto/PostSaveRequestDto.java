package com.jscode.board.dto;

import com.jscode.board.domain.Post;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostSaveRequestDto {
    private String title;
    private String content;

    @Builder
    public PostSaveRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    // 엔티티 변환
    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }
}
