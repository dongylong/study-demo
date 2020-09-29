package com.study.microservices.patterns.controller;

import com.study.microservices.patterns.model.OrderDetails;
import com.study.microservices.patterns.service.KitchenService;
import com.study.microservices.patterns.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/29 14:49
 * @changeRecord
 */
@RestController
public class OrderDetailsController {

    @Resource
    private OrderService orderService;
    @Resource
    private KitchenService kitchenService;
    @Resource
    private DeliveryService deliveryService;
    @Resource
    private AccountingService accountingService;
    @GetMapping("/order/{orderId}")
    public OrderDetails getOrderDetails(@PathVariable String orderId){
        OrderInfo orderInfo = orderService.findOrderById(orderId);
        TicketInfo ticketInfo= kitchenService.findTicketByOrderId(orderId);
        DeliveryInfo deliveryInfo = deliveryService.findDeliveryByOrderId(orderId);
        BillInfo billInfo = accountingService.findBillByOrderId(orderId);
        OrderDetails orderDetails = OrderDetails.makeOrderDetails(orderInfo,ticketInfo,deliveryInfo,billInfo);
    return orderDetails;
    }
}
