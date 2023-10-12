package com.geekster.weeklyTest.project.RestaurantManagementApplication.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;
    private String tokenValue;
    private LocalDateTime tokenCreationDateTime;


    //mapping
    @OneToOne
    @JoinColumn(name = "fk_user_Id")
    User user;


    //create a parameterized constructor which takes user as an argument

    // Coded by: Amit Ashok Swain
    // GitHub - amitashokswain
    // E-mail - business.amitswain@gmail.com
    // Instagram - _sanatani_hindutwa_

    public AuthenticationToken(User user){
        this.user = user;
        this.tokenValue = UUID.randomUUID().toString();
        this.tokenCreationDateTime = LocalDateTime.now();
    }

}
