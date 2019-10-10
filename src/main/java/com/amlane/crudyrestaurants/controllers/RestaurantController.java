package com.amlane.crudyrestaurants.controllers;

import com.amlane.crudyrestaurants.models.Restaurant;
import com.amlane.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController
{
    @Autowired
    private RestaurantService restaurantService; // matches value in Service on RestServImpl

    // GET localhost:2019/restaurants/restaurants
    @GetMapping(value = "/restaurants",
                produces = {"application/json"})
    public ResponseEntity<?> listAllRestaurants()
    {
        List<Restaurant> myList = restaurantService.findall();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    // GET localhost:2019/restaurants/restaurant/:id
    @GetMapping(value = "/restaurant/{restaurantid}",
                produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long restaurantid)
    {
        Restaurant myRest = restaurantService.findById(restaurantid);
        return new ResponseEntity<>(myRest, HttpStatus.OK);
    }

    // POST localhost:2019/restaurants/restaurant
    @PostMapping(value = "/restaurant",
                 consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(@Valid
                                              @RequestBody Restaurant newRestaurant)
    {
        restaurantService.save(newRestaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT localhost:2019/restaurants/restaurant/:id
    @PutMapping(value = "/restaurant/{restaurantid}",
                consumes = {"application/json"})
    public ResponseEntity<?> updateARestaurant(@RequestBody Restaurant restaurant,
                                               @PathVariable long restaurantid)
    {
        restaurantService.update(restaurant, restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE localhost:2019/restaurants/restaurant/:id
    @DeleteMapping(value = "/restaurant/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long restaurantid)
    {
        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
