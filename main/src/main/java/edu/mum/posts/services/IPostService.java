package edu.mum.posts.services;

import edu.mum.posts.domains.Post;

import java.util.List;

public interface IPostService {

    public List<Post> getAll();

    public void addNew(Post post);

    public Post getById(Long id);

    public void update(Post post);

    public void deleteById(Long id);
}
