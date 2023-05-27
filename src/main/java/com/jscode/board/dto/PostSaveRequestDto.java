package com.jscode.board.dto;

import com.jscode.board.domain.Post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostSaveRequestDto {

    @NotBlank(message = "제목은 공백이 될 수 없습니다.")
    @Size(min = 1, max = 15)
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    @Size(min = 1, max = 1000)
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
