package com.study.microservices.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/28 10:22
 * @changeRecord
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreatedEvent {
    private OrderDetails orderDetails;
}
