package com.example.OrderService.dto;

import com.example.OrderService.enums.OrderStatus;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateOrderResponseDTO {

    private Long OrderId;

    private OrderStatus status;
}
