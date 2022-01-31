package edu.mum.commentsmicroservice.controller;

import edu.mum.commentsmicroservice.service.CommentService;
import edu.mum.commentsmicroservice.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentRestController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    @GetMapping("/comments/{id}")
    public Comment get(@PathVariable Long id) {
        return commentService.get(id);

    }

    @PostMapping("/comments")
    public void add(@RequestBody Comment comment) {
        commentService.addComment(comment);

    }
    @PutMapping("/comments/{id}")
    public void update(@PathVariable Long id, @RequestBody Comment comment){
        if (id != comment.getId()) { throw new IllegalArgumentException(); }
        commentService.update(comment);
    }

    @DeleteMapping("/comments/{id}")
    public void delete ( @PathVariable Long id){
        commentService.delete(id);
    }

    @GetMapping("/comments/author/{author}")
    public List<Comment> getAllCommentsByAuthor(@PathVariable String author) {
        return commentService.getAllCommentsByAuthor(author);
    }

    @GetMapping("/comments/post/{postId}")
    public List<Comment> getAllCommentsByPost(@PathVariable Long postId) {
        return commentService.findCommentByPostId(postId);
    }
}
