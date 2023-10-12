package com.geekster.project.RestaurantManagementServiceAPI.Controller;

import com.geekster.project.RestaurantManagementServiceAPI.Model.Food;
import com.geekster.project.RestaurantManagementServiceAPI.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fooditems")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @PostMapping("/create")
    public ResponseEntity<?> createFoodItem(@RequestBody Food foodItem) {
        foodService.createFood(foodItem);
        return ResponseEntity.status(HttpStatus.CREATED).body("Food item created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Food>> getAllFoodItems() {
        List<Food> foodItems = foodService.getAllFoodItems();
        return ResponseEntity.ok(foodItems);
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<Food> getFoodItemById(@PathVariable Integer foodId) {
        Food foodItem = foodService.getFoodById(foodId);
        return ResponseEntity.ok(foodItem);
    }

    @PutMapping("/{foodId}")
    public ResponseEntity<?> updateFoodItem(@PathVariable Integer foodId, @RequestBody Food food) {
        foodService.updateFood(foodId, food);
        return ResponseEntity.ok("Food item updated successfully");
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<?> deleteFoodItem(@PathVariable Integer foodId) {
        foodService.deleteFood(foodId);
        return ResponseEntity.ok("Food item deleted successfully");
    }
}