package com.geekster.project.RestaurantManagementServiceAPI.Repository;

import com.geekster.project.RestaurantManagementServiceAPI.Model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisitorRepo extends JpaRepository<Visitor, Integer> {
}
