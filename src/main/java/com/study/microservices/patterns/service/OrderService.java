package com.study.microservices.patterns.service;

import com.study.microservices.patterns.model.Order;
import com.study.microservices.patterns.model.OrderDetails;
import com.study.microservices.patterns.model.OrderRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:05
 * @changeRecord
 */
@Transactional
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private SagaManager<CreateOrderSagaState> createOrderSagaManager;

    @Resource
    private DomainEventPublisher eventPublisher;

    public Order createOrder(OrderDetails orderDetails){
        ResultWithEvents<Order> orderAndEvents = Order.createOrder();
        Order order = orderAndEvents.result;
        orderRepository.save(order);
        eventPublisher.publish(Order.class,Long.toString(order.getId()) ,orderAndEvents.events);

        CreateOrderSagaState data = new CreateOrderSagaState(order.getId(),orderDetails);
        createOrderSagaManager.create(data,Order.class,order.getId());
        return order;
    }
}
