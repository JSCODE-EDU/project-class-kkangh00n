package com.jscode.board.repository;

import com.jscode.board.domain.Post;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepository {

    private final EntityManager em;

    public Post save(Post post){
        em.persist(post);
        return post;
    }

    public Post find(Long id){
        return em.find(Post.class, id);
    }

    public List<Post> findAll(){
        return em.createQuery("select p from Post p order by p.createDate desc", Post.class)
                .setMaxResults(100)
                .getResultList();
    }

    public void delete(Long id){
        Post findPost = em.find(Post.class, id);
        em.remove(findPost);
    }

}
