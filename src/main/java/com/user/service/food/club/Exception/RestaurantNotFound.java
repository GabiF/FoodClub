package com.user.service.food.club.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "The restaurant you are looking for cannot be found")  // 404
public class RestaurantNotFound extends RuntimeException {
    public RestaurantNotFound(String exception) {
        super(exception);
    }
}