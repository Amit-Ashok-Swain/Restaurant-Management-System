package com.geekster.weeklyTest.project.RestaurantManagementApplication.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer adminId;
    private String adminName;
    @Pattern(regexp = "^.+@admin\\.com$")
    private String adminEmail;
    private String adminPassword;
}

// Coded by: Amit Ashok Swain
// GitHub - amitashokswain
// E-mail - business.amitswain@gmail.com
// Instagram - _sanatani_hindutwa_