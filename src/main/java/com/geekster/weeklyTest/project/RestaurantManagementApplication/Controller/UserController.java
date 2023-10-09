package com.geekster.weeklyTest.project.RestaurantManagementApplication.Controller;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.DTO.SignInInput;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.DTO.SignUpOutput;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Food;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Order;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.User;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.AuthenticationService;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.FoodService;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.OrderService;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController

public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    FoodService foodService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/SignIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }
    @PostMapping("order")
    public String addOrder(@RequestBody Order order, @RequestParam String email, @RequestParam String token){
        if(authenticationService.authenticate(email,token)) {
            boolean foodOrdered = orderService.addOrder(order,email);

            return  foodOrdered?"Food ordered":"The food you are trying to order is Not available in the menu";

        }
        else {
            return "Sign in to order Food";
        }
    }

    @GetMapping("foods")
    public List<Food> getAllFoodItems()
    {
        return foodService.getAllFoodItems();
    }

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_

}
