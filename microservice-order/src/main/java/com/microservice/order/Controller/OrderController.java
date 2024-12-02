package com.microservice.order.Controller;

import com.microservice.order.Client.OrderDetailClient;
import com.microservice.order.Entities.Order;
import com.microservice.order.dto.OrderDetailDTO;
import com.microservice.order.http.Response.ProductsByOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.microservice.order.Repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository ordersRepo;

    @Autowired
    private OrderDetailClient orderClient;

    // Get orders by client name
    @GetMapping("/{name}")
    public List<Order> getClientOrders(@PathVariable String name) {
        return ordersRepo.findByClient(name);
    }

    // Create new order
    @PostMapping
    public Order createOrder(@RequestBody Order newOrder) {
        return ordersRepo.save(newOrder);
    }

    // Update order by id
    @PutMapping("/{id}")
    public Order updatOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order order = ordersRepo.findById(id).orElseThrow();

        order.setClient(orderDetails.getClient());
        order.setDate(orderDetails.getDate());
        order.setTotal(orderDetails.getTotal());

        ordersRepo.save(order);

        return order;
    }

    // Delete an order
    @DeleteMapping("/{id}")
    private Order deteleOrder(@PathVariable Long id) {
        Order order = ordersRepo.findById(id).orElseThrow();
        ordersRepo.delete(order);
        return order;
    }


    // Get order details by order id
    @GetMapping("/details/{order_id}")
    public ProductsByOrderResponse productsInOrder(@PathVariable Long order_id) {

        Order order = ordersRepo.findById(order_id).orElseThrow();

        List<OrderDetailDTO> orderDetailList = orderClient.findAllProductByOrderId(order_id);

        return ProductsByOrderResponse.builder()
                .order_id(order.getId_order())
                .client(order.getClient())
                .productsList(orderDetailList)
                .build();
    }

}
