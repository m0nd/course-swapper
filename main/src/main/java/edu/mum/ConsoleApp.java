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
        System.out.println("EA Group 15...");
    }
}
