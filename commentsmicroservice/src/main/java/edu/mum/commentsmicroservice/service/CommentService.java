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

    public List<Comment> getAll(){
        return commentDao.findAll();
    }

    public void addComment(Comment comment){
        commentDao.save(comment);
    }

    public Comment get(Long id){
        return commentDao.findById(id).get();
    }

    public void update(Comment comment){
        commentDao.save(comment);
    }

    public void delete(Long id){
        commentDao.deleteById(id);
    }
}
