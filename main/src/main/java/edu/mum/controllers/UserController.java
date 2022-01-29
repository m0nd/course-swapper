package edu.mum.controllers;

import edu.mum.users.domain.User;
import edu.mum.users.services.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
}
