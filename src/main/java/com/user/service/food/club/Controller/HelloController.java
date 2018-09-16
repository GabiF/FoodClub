package com.user.service.food.club.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static long start = System.currentTimeMillis();

    @GetMapping("/")
    public String sayHello() {
        return "Hello User";
    }
}
