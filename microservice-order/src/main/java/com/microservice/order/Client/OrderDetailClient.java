package com.microservice.order.Client;

import com.microservice.order.dto.OrderDetailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-order-detail", url = "localhost:8080/order_detail")
public interface OrderDetailClient {

    @GetMapping("/{order_id}")
    List<OrderDetailDTO> findAllProductByOrderId(@PathVariable Long order_id);

}
