package com.jscode.board.Service;

import com.jscode.board.domain.Post;
import com.jscode.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional      //게시글 작성
    public Post savePost(Post post){
        return postRepository.save(post);
    }

    @Transactional      //게시글 수정
    public Post updatePost(Long id, String title, String content){
        Post post = postRepository.find(id);
        post.updatePost(title, content);
        return post;
    }

    //게시글 조회
    public Post findPost(Long id){
        return postRepository.find(id);
    }

    //전체 게시글 조회
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    //게시글 삭제
    @Transactional
    public void deletePost(Long id){
        postRepository.delete(id);
    }

}
