package edu.mum.users.services;

import edu.mum.users.domain.User;

import java.util.List;

public interface IUserService {
    public List<User> getAll();

    public void addNew(User newUser);

    public User getById(Long id);

    public void update(User user);

    public void deleteById(Long id);
}