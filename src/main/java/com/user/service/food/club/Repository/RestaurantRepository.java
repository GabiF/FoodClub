package com.user.service.food.club.Repository;

import com.user.service.food.club.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant findById(long id);
    List<Restaurant> findAll();
}
