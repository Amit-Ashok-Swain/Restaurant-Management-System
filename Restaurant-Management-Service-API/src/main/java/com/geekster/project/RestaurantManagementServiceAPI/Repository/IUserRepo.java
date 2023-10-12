package com.geekster.project.RestaurantManagementServiceAPI.Repository;

import com.geekster.project.RestaurantManagementServiceAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFirstByUserEmail(String newEmail);
}
