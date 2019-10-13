package com.amlane.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "menus")
public class Menu
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    @Column(nullable = false)
    private String dish;


    private double price;

    // from menu -> restaurant there is a relationship that is
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurantid",
                nullable = false)
    @JsonIgnoreProperties({"menus", "hibernateLazyInitializer"})
    private Restaurant restaurant;

    public Menu(String dish, double price, Restaurant restaurant)
    {
        this.dish = dish;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Menu()
    {
        // default constructor
    }

    public long getMenuid()
    {
        return menuid;
    }

    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    public String getDish()
    {
        return dish;
    }

    public void setDish(String dish)
    {
        this.dish = dish;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }
}
