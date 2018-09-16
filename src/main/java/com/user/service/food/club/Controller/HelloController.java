package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.User;
import com.user.service.food.club.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String sayHello() {
        return "Hello User";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public List<User> getUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }
}
