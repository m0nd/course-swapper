package edu.mum.comments.services;

import edu.mum.comments.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
@Service
public class CommentServiceProxy implements ICommentService {
    @Autowired
    private RestTemplate restTemplate;

    private final String commentUrl = "http://localhost:8080/comments/{id}";
    private final String commentsUrl = "http://localhost:8080/comments";

    @Override
    public List<Comment> getAll() {
        ResponseEntity<List<Comment>> response =
                restTemplate.exchange(commentsUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Comment>>() {
                        });
        return response.getBody();
    }

        @Override
        public void addComment(Comment comment) {
            restTemplate.postForLocation(commentsUrl,comment);
        }

        @Override
        public Comment get(Long id){
        return restTemplate.getForObject(commentUrl,Comment.class,id);

        }

        @Override
    public void update(Comment comment){
        restTemplate.put(commentUrl,comment, comment.getId());

        }

     @Override
        public void delete(Long id){
        restTemplate.delete(commentUrl,id);

     }




}
