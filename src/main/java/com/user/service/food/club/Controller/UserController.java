package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.User;
import com.user.service.food.club.Exception.UserNotFoundException;
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
        return "Welcome Page";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/students/{id}")
    public User retrieveStudent(@PathVariable long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("We could not find user: " + id);
        }
        return user;
    }

    @PostMapping("/save")
    User user(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        userRepository.delete(id);
    }

}
