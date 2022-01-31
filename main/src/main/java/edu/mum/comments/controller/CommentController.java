package edu.mum.comments.controller;

import edu.mum.comments.domain.Comment;
import edu.mum.comments.service.ICommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CommentController {
    @Resource
    private ICommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAll(){
        return commentService.getAll();
    }

    @GetMapping("/comments/post/{postId}")
    public List<Comment> getAllCommentsByPost(@PathVariable Long postId) {
        return commentService.findCommentByPostId(postId);
    }

    @GetMapping("/comments/author/{author}")
    public List<Comment> getAllCommentsByAuthor(@PathVariable String author) {
        return commentService.getAllCommentsByAuthor(author);
    }

    @GetMapping("/comments/{id}")
    public Comment get(@PathVariable Long id){
        return commentService.get(id);

    }

    @PostMapping("/comments")
    public void add(@RequestBody Comment comment){
        commentService.addComment(comment);
    }

    @PutMapping("/comments/{id}")
    public void update(@PathVariable Long id,@RequestBody Comment comment) {
        if (id != comment.getId()) {throw new IllegalArgumentException();}
        commentService.update(comment);

    }

    @DeleteMapping("/comments/{id}")
public void delete(@PathVariable Long id){
        commentService.delete(id);
    }
}




