package edu.mum.commentsmicroservice.repository;

import edu.mum.commentsmicroservice.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDao extends JpaRepository<Comment, Long> {
}
