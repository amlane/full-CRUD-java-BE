package com.amlane.crudyrestaurants.repositories;

import com.amlane.crudyrestaurants.models.Menu;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends CrudRepository<Menu, Long>
{
}
