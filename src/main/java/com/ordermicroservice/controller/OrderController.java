package com.ordermicroservice.controller;


import com.ordermicroservice.dto.OrderResponseDTO;
import com.ordermicroservice.model.Order;
import com.ordermicroservice.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("")
    public ResponseEntity<Order> post(@RequestParam String product, @RequestParam int userId) {
        Order order = orderService.createOrder(userId, product);
        return ResponseEntity.ok(order);
    }

    @GetMapping("{userId}")
    public ResponseEntity<OrderResponseDTO> get(@PathVariable int userId) {
        return ResponseEntity.ok(orderService.getOrderByUserId(userId));
    }

//    @GetMapping("{userId}")
//    public ResponseEntity<List<Order>> get(@PathVariable int userId) {
//        return ResponseEntity.ok(
//                Arrays.asList(
//                        new Order(1, 1, "p1"),
//                        new Order(2, 1, "p2"),
//                        new Order(3, 2, "p1")
//                )
//        );
//    }
}
