package edu.mum;

import edu.mum.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import edu.mum.users.domain.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsoleApp implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("All in all");
//        List<User> userList = userService.getAll();
//        System.out.println(userList);
//        User user1 = userService.getById(1L);
//        userService.addNew(new User("Buju"));
//        System.out.println(userService.getAll());
//        user1.setName("Wendy");
//        userService.update(user1);
//        System.out.println(userService.getAll());
//        userService.deleteById(2L);
//        System.out.println(userService.getAll());
//        user1 = userService.getAll().get(0);
//        System.out.println(user1.getName());
    }
}
