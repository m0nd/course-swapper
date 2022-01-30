package edu.mum.postService.Service;

import edu.mum.postService.Domain.Post;
import edu.mum.postService.Repository.IPostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class PostService implements IPostService{

    @Autowired
    IPostDao postDao;

    @Override
    public void addPost(Post post) {
        postDao.save(post);
    }

    @Override
    public List<Post> getAll() {
        return postDao.findAll();
    }

    @Override
    public Post get(Long id) {
        return postDao.findById(id).orElse(null);
    }

    @Override
    public void update( Post post) {
        postDao.save(post);
    }

    @Override
    public void delete(Long id) {
        postDao.deleteById(id);
    }
}
