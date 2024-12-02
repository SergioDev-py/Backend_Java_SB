package com.microservice.orderDetails.Controllers;

import com.microservice.orderDetails.Entities.OrderDetails;
import com.microservice.orderDetails.Repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order_detail")
public class OrderDetailController {

    @Autowired
    OrderDetailRepository orderDetailRepo;

    @GetMapping("/{order_id}")
    public List<OrderDetails> getOrderDetails(@PathVariable Long order_id) {
        return orderDetailRepo.findByOrderId(order_id);
    }

}
