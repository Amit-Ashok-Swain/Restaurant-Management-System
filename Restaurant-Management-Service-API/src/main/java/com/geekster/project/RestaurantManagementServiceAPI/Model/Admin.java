package com.geekster.project.RestaurantManagementServiceAPI.Model;


import jakarta.validation.constraints.Pattern;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    private String adminName;

    @Pattern(regexp = "^.+@admin\\.com$")
    private String adminEmail;
    private LocalDateTime createdAt;

}

