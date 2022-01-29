package edu.mum.users.controllers;

import edu.mum.users.domain.User;
import edu.mum.users.services.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/users")
    public void add(@RequestBody User newUser) {
        userService.addNew(newUser);
    }

    @PutMapping("/users/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        if (id != user.getId()) throw new IllegalArgumentException();
        userService.update(user);
    }

    @DeleteMapping("/users/{id}")
    public void delete (@PathVariable Long id) {
        userService.deleteById(id);
    }
}
