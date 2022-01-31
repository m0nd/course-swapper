package edu.mum.commentsmicroservice.repository;

import edu.mum.commentsmicroservice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICommentDao extends JpaRepository<Comment, Long> {

    @Query("select c from Comment c where c.author like %?1")
    List<Comment> findCommentByAuthor(String author);

    List<Comment> findCommentByPostId(Long id);
}
