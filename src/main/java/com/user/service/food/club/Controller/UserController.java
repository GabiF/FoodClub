package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.User;
import com.user.service.food.club.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String sayHello() {
        return "Hello User";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public List<User> retrieveAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }


    @GetMapping("/students/{id}")
    public User retrieveStudent(@PathVariable long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return null;
        }
        return user;
    }
}
