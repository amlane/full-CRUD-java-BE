package com.amlane.crudyrestaurants.repositories;

import com.amlane.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long>
{
}
