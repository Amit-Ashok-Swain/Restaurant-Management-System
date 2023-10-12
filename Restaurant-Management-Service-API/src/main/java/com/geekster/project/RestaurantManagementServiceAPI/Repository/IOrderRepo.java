package com.geekster.project.RestaurantManagementServiceAPI.Repository;

import com.geekster.project.RestaurantManagementServiceAPI.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order, Integer> {
}