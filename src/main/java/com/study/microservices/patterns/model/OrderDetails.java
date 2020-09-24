package com.study.microservices.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:28
 * @changeRecord
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    private Long restaurantId;
    private Long orderId;
    private OrderLineItems lineItems;
}
