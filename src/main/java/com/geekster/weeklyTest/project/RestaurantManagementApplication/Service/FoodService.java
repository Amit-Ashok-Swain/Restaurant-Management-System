package com.geekster.weeklyTest.project.RestaurantManagementApplication.Service;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Food;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Repository.IFoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    IFoodRepo iFoodRepo;

    public void addFoodItem(Food food) {
        iFoodRepo.save(food);
    }

    public boolean isFoodInTheMenu(Food food) {

        Integer id = food.getFoodId();

        return iFoodRepo.existsById(id);
    }

    public List<Food> getAllFoodItems() {
        return iFoodRepo.findAll();
    }
}

// Coded by: Amit Ashok Swain
// GitHub - amitashokswain
// E-mail - business.amitswain@gmail.com
// Instagram - _sanatani_hindutwa_