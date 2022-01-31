package edu.mum.commentsmicroservice.service;

import edu.mum.commentsmicroservice.repository.ICommentDao;
import edu.mum.commentsmicroservice.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService implements ICommentService {
    @Autowired
    private ICommentDao commentDao;

    @Override
    public List<Comment> getAll(){
        return commentDao.findAll();
    }

    @Override
    public void addComment(Comment comment){
        commentDao.save(comment);
    }

    @Override
    public Comment get(Long id){
        return commentDao.findById(id).get();
    }

    @Override
    public void update(Comment comment){
        commentDao.save(comment);
    }

    @Override
    public void delete(Long id){
        commentDao.deleteById(id);
    }

    @Override
    public List<Comment> getAllCommentsByAuthor(String author){
        return commentDao.findCommentByAuthor(author);

    }

    @Override
    public List<Comment> findCommentByPostId(Long id){
        return commentDao.findCommentByPostId(id);

    }
}
