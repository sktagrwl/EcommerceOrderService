package com.example.OrderService.mapper;


import com.example.OrderService.dto.OrderItemRequestDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;

public class OrderItemMapper {

    public static OrderItem OrderItemRequestDTOtoOrderItemEntity(OrderItemRequestDTO itemRequestDTO, Order order, double pricePerUnit, double totalPrice){


        return OrderItem.builder()
                .productId(itemRequestDTO.getProductId())
                .quantity(itemRequestDTO.getQuantity())
                .pricePerUnit(pricePerUnit)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
