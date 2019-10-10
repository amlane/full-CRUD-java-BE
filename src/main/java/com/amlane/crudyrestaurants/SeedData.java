package com.amlane.crudyrestaurants;
import com.amlane.crudyrestaurants.models.Menu;
import com.amlane.crudyrestaurants.models.Restaurant;
import com.amlane.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    RestaurantService restaurantService;
    @Override
    public void run(String[] args) throws Exception
    {
        // Restaurant String name, String address, String city, String state, String telephone
        String rest1Name = "Apple Cafe";
        Restaurant r1 = new Restaurant(rest1Name,
                "123 Least Street",
                "City",
                "PR",
                "555-555-1234");
        r1.getMenus()
                .add(new Menu("Mac and Cheese",
                        5.95,
                        r1));
        r1.getMenus()
                .add(new Menu("Lasagna",
                        15.50,
                        r1));
        restaurantService.save(r1);
        String rest2Name = "Raven Cafe";
        Restaurant r2 = new Restaurant(rest2Name,
                "321 Downtown Drive",
                "Town",
                "PR",
                "555-555-5555");
        r2.getMenus()
                .add(new Menu("Tacos",
                        10.49,
                        r2));
        r2.getMenus()
                .add(new Menu("Barbacoa",
                        12.75,
                        r2));
        r2.getMenus()
                .add(new Menu("Combo Plate",
                        12.95,
                        r2));
        restaurantService.save(r2);
        String rest3Name = "Supreme Eats";
        Restaurant r3 = new Restaurant(rest3Name,
                "565 Front Avenue",
                "Village",
                "ST",
                "555-123-1555");
        r3.getMenus()
                .add(new Menu("Pizza",
                        7.77,
                        r3));
        restaurantService.save(r3);
        // This will print to the console the seed data
        List<Restaurant> printList = restaurantService.findall();
        System.out.println("\n********** SEED DATA **********");
        for (Restaurant r : printList)
        {
            System.out.println(r);
        }
        System.out.println("********** SEED DATA **********\n");
    }
}