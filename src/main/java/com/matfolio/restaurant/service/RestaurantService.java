package com.matfolio.restaurant.service;

import com.matfolio.restaurant.dto.RestaurantResponseDto;
import com.matfolio.restaurant.model.Restaurant;
import com.matfolio.restaurant.repository.RestaurantRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RestaurantService implements RestaurantRepository {
    public HashMap<String, Restaurant> restaurants = new HashMap<>();
    @Override
    public RestaurantResponseDto getByName(String name) {
        try {
            Thread.sleep(5000L);
            Restaurant restaurant = getRestaurant(name);
            return new RestaurantResponseDto(restaurant.getName());
        } catch (Exception e) {
            System.out.println("Restaurant not found: " + e.getMessage());
            return null;
        }
    }

    public  Restaurant getRestaurant(String name) {
        return restaurants.get(name);
    }

    public void addRestaurant(String name, Restaurant restaurant) {
        restaurants.put(name, restaurant);
    }

    public HashMap<String, Restaurant> getRestaurants() {
        return restaurants;
    }

}
