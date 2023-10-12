package com.geekster.project.RestaurantManagementServiceAPI.Model;

import com.geekster.project.RestaurantManagementServiceAPI.Enums.FoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;
    private String foodTitle;
    private String foodDesc;
    @Enumerated(EnumType.STRING)
    private FoodType foodType;
    private String foodImg;
    private Double foodPrice;
    private LocalDateTime createdAt;
}