package com.geekster.project.RestaurantManagementServiceAPI.Model;

import com.geekster.project.RestaurantManagementServiceAPI.Enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer orderQuantity;
    private OrderStatus orderStatus;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "fk_food_Id")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "fk_user_Id")
    private User customer;
}