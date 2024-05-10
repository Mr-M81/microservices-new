package com.programmingwithkabelo.OrderService.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="t_orderitems_")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItems {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)// auto generator
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
