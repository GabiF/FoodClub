package com.user.service.food.club.Controller;

import com.user.service.food.club.Entity.Restaurant;
import com.user.service.food.club.Exception.RestaurantNotFound;
import com.user.service.food.club.Exception.UserNotFoundException;
import com.user.service.food.club.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    RestaurantRepository restaurantRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity retrieveAllUsers() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        if (restaurants.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable("id") long id) {
        Restaurant restaurant = restaurantRepository.findById(id);
        if (restaurant == null) {
            throw new UserNotFoundException("We could not find user: " + id);
        }
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Restaurant> deleteRestaurant(@PathVariable Long id) {

        Restaurant restaurant = restaurantRepository.findById(id);
        if (restaurant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        restaurantRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Restaurant> updateRestaurantDetails(@RequestBody Restaurant restaurant, @PathVariable Long id) {
        Restaurant optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant == null)
            throw new RestaurantNotFound("The restaurant you want to update cannot be found: " + id);
        try {
            optionalRestaurant.setEmail(restaurant.getEmail());
            optionalRestaurant.setName(restaurant.getName());
            optionalRestaurant.setPassword(restaurant.getPassword());
            restaurantRepository.save(optionalRestaurant);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
