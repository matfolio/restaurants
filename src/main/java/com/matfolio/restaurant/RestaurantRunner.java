package com.matfolio.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RestaurantRunner {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantRunner.class, args);
    }

}
