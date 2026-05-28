package com.matfolio.restaurant.repository;

import com.matfolio.restaurant.dto.RestaurantResponseDto;
import com.matfolio.restaurant.model.Restaurant;

public interface RestaurantRepository {
    RestaurantResponseDto getByName(String name);
}
