package edu.mum.commentsmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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


}
