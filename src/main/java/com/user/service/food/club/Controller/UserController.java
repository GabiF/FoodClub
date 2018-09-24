package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.User;
import com.user.service.food.club.Exception.UserNotFoundException;
import com.user.service.food.club.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new UserNotFoundException("We could not find user: " + id);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> delete(@PathVariable Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) {
        User userOptional = userRepository.findById(id);
        if (userOptional == null)
            throw new UserNotFoundException("The user you want to update cannot be found: " + id);
        try {
            userOptional.setEmail(user.getEmail());
            userOptional.setFirstName(user.getFirstName());
            userOptional.setLastName(user.getLastName());
            userOptional.setPassword(user.getPassword());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
        userRepository.save(userOptional);
        return ResponseEntity.ok().build();
    }
}
