package com.matfolio.restaurant.controller;

import com.matfolio.restaurant.dto.RestaurantResponseDto;
import com.matfolio.restaurant.model.Restaurant;
import com.matfolio.restaurant.service.RestaurantService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @GetMapping("/{name}")
    @Cacheable(value = "restaurant", key="#name")
    public RestaurantResponseDto getRestaurant(@PathVariable String name) {
        RestaurantResponseDto restaurant =  restaurantService.getByName(name);
        if  (restaurant != null) {
            Restaurant r = new Restaurant(name);
            restaurantService.addRestaurant(name, r);
            return restaurant;
        }
        return null;
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Restaurant>> getAllRestaurant() {
        return ResponseEntity.ok().body(restaurantService.getRestaurants());
    }

    @PostMapping
    @CachePut(value="restaurant", key = "#restaurant.getName()")
    public RestaurantResponseDto createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant.getName(), restaurant);
        return new RestaurantResponseDto(restaurant.getName());
    }

    @DeleteMapping("/{name}")
    @CacheEvict(value="restaurant", key = "#name")
    public void deleteRestaurant(@PathVariable String name) {
        restaurantService.getRestaurants().remove(name);
    }
}
