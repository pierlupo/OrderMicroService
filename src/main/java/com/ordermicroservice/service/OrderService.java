package com.ordermicroservice.service;


import com.ordermicroservice.dto.OrderResponseDTO;
import com.ordermicroservice.dto.UserDTO;
import com.ordermicroservice.model.Order;
import com.ordermicroservice.repository.OrderRepo;
import com.ordermicroservice.tool.RestClient;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepo orderRepo;


    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(int userId, String product) {
        Order order = Order.builder().userId(userId).product(product).build();
        orderRepo.save(order);
        return order;
    }

    public OrderResponseDTO getOrderByUserId(int userId) {
        RestClient<UserDTO, String> restClient = new RestClient<>();
        OrderResponseDTO orderResponseDTO = OrderResponseDTO.builder()
                .orders(orderRepo.findAllByUserId(userId))
                .userDTO(restClient.get("user/"+userId, UserDTO.class))
                .build();
        return orderResponseDTO;
    }
}
