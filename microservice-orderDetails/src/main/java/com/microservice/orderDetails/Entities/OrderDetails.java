package com.microservice.orderDetails.Entities;

import jakarta.persistence.*;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Data
@Entity
@Table(name = "order_detail")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private Integer quantity;

}
