package edu.mum.users.services;

import edu.mum.users.dao.IUserDao;
import edu.mum.users.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService implements IUserService {
    @Resource
    private IUserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public void addNew(User newUser) {
        userDao.save(newUser);
    }

    public User getById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
