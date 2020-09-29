package com.study.microservices.patterns.handlers;

import com.study.microservices.patterns.event.consumer.DomainEventEnvelope;
import com.study.microservices.patterns.model.Order;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/29 10:57
 * @changeRecord
 */
public class OrderHistoryEventHandlers {
    private OrderHistoryDao orderHistoryDao;

    public OrderHistoryEventHandlers(OrderHistoryDao orderHistoryDao) {
        this.orderHistoryDao = orderHistoryDao;
    }

    public void handleOrderCreated(DomainEventEnvelope<OrderCreated> dee) {
       orderHistoryDao.addOrder(makeOrder(dee.getAggregateId(),dee.getEvent()),makeSourceEvent(dee));
    }

    private Order makeSourceEvent(DomainEventEnvelope<OrderCreated> dee) {
        return null;
    }

    private Order makeOrder(String aggregateId, OrderCreated event) {
        return null;
    }

    private void handleDeliveryPickedUp(DomainEventEnvelope<DeliveryPickedUp> dee) {
        orderHistoryDao.notePickedUp(dee.getEvent().getOrderId());
    }

}
