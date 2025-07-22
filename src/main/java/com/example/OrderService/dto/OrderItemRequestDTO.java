package com.example.OrderService.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequestDTO {

    private Long productId;

    private int quantity;

}
