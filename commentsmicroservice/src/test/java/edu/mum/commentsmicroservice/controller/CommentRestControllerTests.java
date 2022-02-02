package edu.mum.commentsmicroservice.controller;

import edu.mum.commentsmicroservice.domain.Comment;
import edu.mum.commentsmicroservice.service.CommentService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CommentRestControllerTests {

    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentRestController commentRestController = new CommentRestController();

    Comment comment1 = new Comment(1L, "This is my first comment", "Lucy", 1L);
    Comment comment2 = new Comment(2L, "This is my second comment", "Lucy", 2L);
    Comment comment3 = new Comment(3L, "I do not care", "James", 1L);
    List<Comment> comments = List.of(comment1, comment2, comment3);


    @Test
    public void testGetAllComments() {
        when(commentService.getAll()).thenReturn(comments);
        List<Comment> responseFromController = commentRestController.getAll();
        assertNotNull(responseFromController);
        assertEquals(comments, responseFromController);
        assertEquals(comments.size(), responseFromController.size());
    }

    @Test
    public void testGetCommentById() {
        when(commentService.get(1L)).thenReturn(comments.get(1));
        Comment responseFromController = commentRestController.get(1L);
        assertNotNull(responseFromController);
        assertEquals(comments.get(1), responseFromController);
    }

    @Test
    public void testGetAllCommentsByAuthor() {
        when(commentService.getAllCommentsByAuthor("Lucy")).thenReturn(List.of(comments.get(0),comments.get(1)));
        List<Comment> responseFromController = commentRestController.getAllCommentsByAuthor("Lucy");
        assertNotNull(responseFromController);
        assertEquals(2, responseFromController.size());
        assertEquals("Lucy", responseFromController.get(1).getAuthor());
    }

}
