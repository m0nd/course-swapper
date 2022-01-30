package edu.mum.commentsmicroservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentDao extends JpaRepository<Comment, Long> {
}
