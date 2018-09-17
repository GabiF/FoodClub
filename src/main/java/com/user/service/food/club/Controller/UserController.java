package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.User;
import com.user.service.food.club.Exception.UserNotFoundException;
import com.user.service.food.club.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/users/{id}")
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

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable Long id) {
        User userOptional = userRepository.findById(id);

        if (userOptional == null)
            throw new UserNotFoundException("The user you want to update cannot be found: " + id);

        userOptional.setId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
