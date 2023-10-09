package com.geekster.weeklyTest.project.RestaurantManagementApplication.Controller;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Admin;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.DTO.SignUpOutput;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Food;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.AdminService;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Service.FoodService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Validated
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    FoodService foodService;
    @PostMapping("Admin/signUp")
    public SignUpOutput addAdmin(@RequestBody @Valid Admin admin)
    {
        return adminService.addAdmin(admin);
    }

    @PostMapping("food")
    public String addFoodItem(@RequestBody @Valid Food food , @RequestParam String adminEMail)
    {
        boolean adminOrNot = adminService.ifAdminExistOrNot(adminEMail);

        if(adminOrNot)
        {
            foodService.addFoodItem(food);
            return "New Food Item added to the menu";
        }
        else return  "Unauthorized access ";

    }

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_
}