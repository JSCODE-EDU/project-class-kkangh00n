package com.jscode.board.repository;

import com.jscode.board.Service.PostService;
import com.jscode.board.domain.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostService postService;


    @Rollback(value = true)
    @Test
    public void findAll(){

        for(int i=0; i<200; i++){
            Post post = Post.builder()
                    .title("제목" + i)
                    .content("내용" + i)
                    .build();
        }

        List<Post> all = postRepository.findAll();

        assertEquals("전체 조회 시 100개 출력",100, all.size());

    }
}