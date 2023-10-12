package com.geekster.project.RestaurantManagementServiceAPI.Repository;

import com.geekster.project.RestaurantManagementServiceAPI.Model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodRepo extends JpaRepository<Food, Integer> {
}
