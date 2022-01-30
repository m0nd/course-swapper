package edu.mum.postService.Repository;

import edu.mum.postService.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostDao extends JpaRepository<Post,Long> {
}
