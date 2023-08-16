package com.ordermicroservice.service;


import com.ordermicroservice.model.Order;
import com.ordermicroservice.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    Order saveOrder(int orderId, int userId, String product) {
        Order order = new Order(orderId, userId, product);
        return orderRepo.save(order);
    }

    Optional<Order> findById(int id) {
        return orderRepo.findById(id);
    }
}
