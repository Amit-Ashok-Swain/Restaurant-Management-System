package com.geekster.project.RestaurantManagementServiceAPI.Repository;


import com.geekster.project.RestaurantManagementServiceAPI.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin, Integer> {
    Admin findFirstByAdminEmail(String email);
}

