package com.jscode.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PostUpdateRequestDto {
    @NotBlank(message = "제목은 공백이 될 수 없습니다.")
    @Size(min = 1, max = 15)
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    @Size(min = 1, max = 1000)
    private String content;
}
