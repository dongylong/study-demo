package com.study.microservices.patterns.model;

import com.study.microservices.patterns.controller.BillInfo;
import com.study.microservices.patterns.controller.DeliveryInfo;
import com.study.microservices.patterns.controller.OrderInfo;
import com.study.microservices.patterns.controller.TicketInfo;
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

    public static OrderDetails makeOrderDetails(OrderInfo orderInfo, TicketInfo ticketInfo, DeliveryInfo deliveryInfo, BillInfo billInfo) {
        return null;
    }
}
