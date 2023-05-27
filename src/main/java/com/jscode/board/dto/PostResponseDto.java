package com.jscode.board.dto;

import com.jscode.board.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public PostResponseDto(Long id, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public static PostResponseDto fromEntity(Post post){
        return PostResponseDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdDate(post.getCreateDate())
                .modifiedDate(post.getModifiedDate())
                .build();
    }

}
