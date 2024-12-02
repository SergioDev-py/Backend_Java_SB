package com.microservice.order.http.Response;

import com.microservice.order.dto.OrderDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsByOrderResponse {

    private Long order_id;
    private String client;
    private List<OrderDetailDTO> productsList;

}
