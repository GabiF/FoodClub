package com.user.service.food.club.Repository;

import com.user.service.food.club.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);
    List<User> findAll();
}
