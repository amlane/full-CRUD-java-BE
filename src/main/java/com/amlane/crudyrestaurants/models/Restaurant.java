package com.amlane.crudyrestaurants.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity // make this a table in my database
@Table(name = "restaurants")
public class Restaurant
{
    @Id // primary key that is unique
    @GeneratedValue(strategy = GenerationType.AUTO) // generate an ID for me
    private long restaurantid;

    @Column(unique = true,
            nullable = false)
    private String name;

    private String address;
    private String city;
    private String state;
    private String telephone;

    // one restaurant to many menus, connected by restaurantid
    @OneToMany(mappedBy = "restaurant",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties("restaurant")
    private List<Menu> menus = new ArrayList<>();

    public Restaurant(String name, String address, String city, String state, String telephone)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
    }

    public Restaurant()
    {
        // default constructor
    }

    public long getRestaurantid()
    {
        return restaurantid;
    }

    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }
}
