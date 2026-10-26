package com.matfolio.restaurant.repository;

import com.matfolio.restaurant.dto.RestaurantResponseDto;

public interface RestaurantRepository {
    RestaurantResponseDto getByName(String name);
}
