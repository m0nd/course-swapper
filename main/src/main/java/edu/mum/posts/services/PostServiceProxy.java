package edu.mum.posts.services;

import edu.mum.posts.domains.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostServiceProxy implements IPostService {

    @Autowired
    private RestTemplate restTemplate;
    private final String postUrl = "http://localhost:8083/posts/{id}";
    private final String postsUrl = "http://localhost:8083/posts";

    @Override
    public List<Post> getAll() {
        ResponseEntity<List<Post>> response = restTemplate.exchange(postsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Post>>() {});
        return response.getBody();
    }

    @Override
    public void addNew(Post post) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Post> httpEntity = new HttpEntity<>(post, headers);

        restTemplate.postForObject(postsUrl, httpEntity, Post.class);
    }

    @Override
    public Post getById(Long id) {
        return restTemplate.getForObject(postUrl, Post.class, id);
    }

    @Override
    public void update(Post post) {
        restTemplate.put(postUrl, post, post.getId());
    }

    @Override
    public void deleteById(Long id) {
        restTemplate.delete(postUrl, id);
    }
}
