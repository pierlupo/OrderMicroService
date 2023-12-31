package com.ordermicroservice.repository;

import com.ordermicroservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Integer> {

    List<Order> findAllByUserId(int userId);
}
