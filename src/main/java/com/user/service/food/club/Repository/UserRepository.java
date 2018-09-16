package com.user.service.food.club.Repository;

import com.user.service.food.club.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstName(String firstName);

    User findById(long id);

    List<User> findAll();
}
