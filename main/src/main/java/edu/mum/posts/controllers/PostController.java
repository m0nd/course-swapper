package edu.mum.posts.controllers;

import edu.mum.posts.domains.Post;
import edu.mum.posts.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    IPostService postService;

    @PostMapping
    public void addPost(@RequestBody Post post) {
        postService.addNew(post);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable Long id) {
        return postService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Post post) {
        if (!Objects.equals(id, post.getId())) throw new IllegalArgumentException();
        postService.update(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        postService.deleteById(id);
    }

}

