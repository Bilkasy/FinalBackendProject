package com.example.FoodProject.repositories;

import com.example.FoodProject.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Integer> {
     MenuItem findByName(String name);
//     List<MenuItem>findAll();
}
