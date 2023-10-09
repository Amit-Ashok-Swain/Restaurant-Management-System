package com.geekster.weeklyTest.project.RestaurantManagementApplication.Service;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Food;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Order;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.User;
import com.geekster.weeklyTest.project.RestaurantManagementApplication.Repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo iOrderRepo;
    @Autowired
    UserService userService;
    @Autowired
    FoodService foodService;
    public boolean addOrder(Order order, String email) {
        Food food = order.getFood();

        boolean foodAvail = foodService.isFoodInTheMenu(food);
        User user = userService.findFirstByUserEmail(email);
        if(foodAvail)
        {
            order.setCustomer(user);
            iOrderRepo.save(order);
            return true;
        }
        else
            return false;


    }

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_
}
