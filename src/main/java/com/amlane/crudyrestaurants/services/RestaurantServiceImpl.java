package com.amlane.crudyrestaurants.services;

import com.amlane.crudyrestaurants.models.Menu;
import com.amlane.crudyrestaurants.models.Restaurant;
import com.amlane.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImpl implements RestaurantService
{
    @Autowired  // spring does all the work for me
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findall()
    {
        List<Restaurant> rtnList = new ArrayList<>();
        restrepos.findAll()
                .iterator()
                .forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public Restaurant findById(long id)
    {
        return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found " + id));
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant)
    {
        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());

        for (Menu m : restaurant.getMenus())
        {
            newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
        }
        return restrepos.save(newRestaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, long id)
    {
        Restaurant currentRestaurant = restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (restaurant.getName() != null) {
            currentRestaurant.setName(restaurant.getName());
        }

        if (restaurant.getAddress() != null) {
            currentRestaurant.setAddress(restaurant.getAddress());
        }

        if (restaurant.getCity() != null)
        {
            currentRestaurant.setCity(restaurant.getCity());
        }

        if(restaurant.getState() != null)
        {
            currentRestaurant.setState(restaurant.getState());
        }

        if(restaurant.getTelephone() != null)
        {
            currentRestaurant.setTelephone(restaurant.getTelephone());
        }

        if(restaurant.getMenus().size() > 0)
        {
            for(Menu m : restaurant.getMenus())
            {
                currentRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), currentRestaurant));
            }
        }

        return restrepos.save(currentRestaurant);

    }

    @Override
    public void delete(long id)
    {
        restrepos.deleteById(id);
    }
}
