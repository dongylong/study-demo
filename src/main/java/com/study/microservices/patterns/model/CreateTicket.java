package com.study.microservices.patterns.model;

import com.study.microservices.patterns.model.OrderDetails;
import javafx.beans.property.adapter.JavaBeanBooleanPropertyBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:52
 * @changeRecord
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTicket {
    private Long restaurantId;
    private Long orderId;
    private OrderDetails orderDetails;
}
