package com.geekster.weeklyTest.project.RestaurantManagementApplication.Controller;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Food;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VisitorController {

    @Autowired
    FoodService foodService;

    @GetMapping("food")
    public List<Food> getAllFoodItems()
    {
        return foodService.getAllFoodItems();
    }

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_

}