package com.geekster.weeklyTest.project.RestaurantManagementApplication.Model;


import com.geekster.weeklyTest.project.RestaurantManagementApplication.Model.Enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer orderQuantity;
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name ="fk_food_Id")
    private Food food;

    @ManyToOne
    @JoinColumn(name="fk_user_Id")
    private User customer;

}

// Coded by: Amit Ashok Swain
// GitHub - amitashokswain
// E-mail - business.amitswain@gmail.com
// Instagram - _sanatani_hindutwa_

/* orderID
            FoodItem   ID,
            quantity,
            UserID,
            status  // status will be created, dispatch, delivered
 */
