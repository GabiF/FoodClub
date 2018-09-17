package com.user.service.food.club.Repository;

import com.user.service.food.club.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    List<User> findAll();
}
