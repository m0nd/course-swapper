package edu.mum.comments.service;

import edu.mum.comments.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceProxy implements ICommentService {
    @Autowired
    private RestTemplate restTemplate;

    private final String commentUrl = "http://localhost:8082/comments/{id}";
    private final String commentsUrl = "http://localhost:8082/comments";

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

    @Override
    public List<Comment> findCommentByPostId(Long postId){
//        HttpHeaders headers = new HttpHeaders();
//        Map<String, Long> params = new HashMap<>();
//        params.put("postId", postId);
//
//        headers.setContentType(MediaType.APPLICATION_JSON);

//        HttpEntity<Long> httpEntity = new HttpEntity<>(postId , headers);
        String updatedCommentsUrl = commentsUrl + "/post/" + postId.longValue();
        ResponseEntity<List<Comment>> response = restTemplate.exchange(updatedCommentsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Comment>>() {
                });
        return response.getBody();
    }


    @Override
    public List<Comment> getAllCommentsByAuthor(String author) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_PLAIN);
//
//        HttpEntity<String> httpEntity = new HttpEntity<>(author, headers);
        String updatedCommentsUrl = commentsUrl + "/author/" + author;
        ResponseEntity<List<Comment>> response = restTemplate.exchange(updatedCommentsUrl, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Comment>>() {
                });
        return response.getBody();
    }




}
