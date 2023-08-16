package com.ordermicroservice.dto;

import com.ordermicroservice.model.Order;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderResponseDTO {
    private List<Order> orders;
    private UserDTO userDTO;
}