package com.jscode.board.Service;

import com.jscode.board.domain.Post;
import com.jscode.board.dto.PostSaveRequestDto;
import com.jscode.board.dto.PostResponseDto;
import com.jscode.board.dto.PostUpdateRequestDto;
import com.jscode.board.repository.PostJpaRepository;
import com.jscode.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostJpaRepository postRepository;

    @Transactional      //게시글 작성
    public PostResponseDto savePost(PostSaveRequestDto postSaveRequestDto){
        Post savePost = postSaveRequestDto.toEntity();
        postRepository.save(savePost);
        return PostResponseDto.fromEntity(savePost);
    }

    @Transactional      //게시글 수정, 엔티티에서 기능 실행
    public PostResponseDto updatePost(Long id, PostUpdateRequestDto postUpdateRequestDto){
        Post updatePost = postRepository.findById(id).get();
        updatePost.updatePost(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        return PostResponseDto.fromEntity(updatePost);
    }

    //게시글 조회
    public PostResponseDto findPost(Long id){
        Post findPost = postRepository.findById(id).get();
        return PostResponseDto.fromEntity(findPost);
    }

    //전체 게시글 조회
    public List<PostResponseDto> findAll(){
        List<Post> findAll = postRepository.findAll();
        return findAll.stream().map(PostResponseDto::fromEntity).collect(Collectors.toList());
    }

    //게시글 삭제
    @Transactional
    public void deletePost(Long id){
        Post post = postRepository.findById(id).get();
        postRepository.delete(post);
    }

//    //게시글 검색 조회
//    public List<Post> searchFindPost(String keyword){
//        return postRepository.searchFindPost(keyword);
//    }

}
