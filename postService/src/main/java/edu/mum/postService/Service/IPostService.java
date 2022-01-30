package edu.mum.postService.Service;

import edu.mum.postService.Domain.Post;

import java.util.List;

public interface IPostService {

    public void addPost(Post post);
    public List<Post> getAll();
    public Post get(Long id);
    public void update( Post post);
    public void delete(Long id);


}
