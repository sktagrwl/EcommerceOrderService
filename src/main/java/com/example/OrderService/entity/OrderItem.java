package com.example.OrderService.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="orderItems")
public class OrderItem extends BaseEntity{

    private Long productId;

    private int quantity;

    private double pricePerUnit;

    private double totalPrice;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;


}
