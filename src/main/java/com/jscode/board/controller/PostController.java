package com.jscode.board.controller;

import com.jscode.board.Service.PostService;
import com.jscode.board.domain.Post;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        for(int i=0; i<200; i++){
            postService.savePost(Post.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .build());
        }
    }

    //게시글 작성
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Post createPost(@RequestBody Post p){
        return postService.savePost(p);
    }

    //전체 게시글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Post> list(){
        return postService.findAll();
    }

    //단일 게시글 조회
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Post findPost(@PathVariable Long id){
        return postService.findPost(id);
    }

    //게시글 업데이트
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post p){
        return postService.updatePost(id, p.getTitle(), p.getContent());
    }

    //게시글 삭제
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return "ok";
    }

    //게시글 제목 검색
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/search")
    public List<Post> search(@RequestParam("keyword") String keyword){
        return postService.searchFindPost(keyword);
    }

}
