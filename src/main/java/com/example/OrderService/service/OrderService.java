package com.example.OrderService.service;

import com.example.OrderService.clients.ProductServiceClient;
import com.example.OrderService.dto.CreateOrderResponseDTO;
import com.example.OrderService.dto.OrderItemRequestDTO;
import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.ProductDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItem;
import com.example.OrderService.mapper.OrderItemMapper;
import com.example.OrderService.mapper.OrderMapper;
import com.example.OrderService.repository.IOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService{

    private final IOrderRepository orderRepository;

    private final ProductServiceClient productServiceClient;

    public OrderService(IOrderRepository orderRepository, ProductServiceClient productServiceClient) {
        this.orderRepository = orderRepository;
        this.productServiceClient = productServiceClient;
    }

    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDTO requestDTO) {

        //Persist the order in order table > OrderRequestDTO > Order Entity
        Order order = OrderMapper.toEntity(requestDTO);

        List<OrderItem> items = new ArrayList<>();

        for(OrderItemRequestDTO itemDTO : requestDTO.getItems()){

            //fetch the product details for every item

            ProductDTO product = productServiceClient.getProductById(itemDTO.getProductId());

            double pricePerUnit = product.getPrice();
            double totalPrice = pricePerUnit *itemDTO.getQuantity();

            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                    itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );

            items.add(item);

        }
        order.setItems(items);
        Order createdOrder = orderRepository.save(order);
        return OrderMapper.toCreateOrderResponseDTO(createdOrder);


    }


}
