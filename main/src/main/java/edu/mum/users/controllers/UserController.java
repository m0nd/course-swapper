package edu.mum.users.controllers;

import edu.mum.users.domain.User;
import edu.mum.users.services.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User get(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public void add(@RequestBody User newUser) {
        userService.addNew(newUser);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
        if (id != user.getId()) throw new IllegalArgumentException();
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        userService.deleteById(id);
    }
}
