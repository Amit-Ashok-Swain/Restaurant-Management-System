package com.geekster.weeklyTest.project.RestaurantManagementApplication.Repository;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

}

// Coded by: Amit Ashok Swain
// GitHub - amitashokswain
// E-mail - business.amitswain@gmail.com
// Instagram - _sanatani_hindutwa_