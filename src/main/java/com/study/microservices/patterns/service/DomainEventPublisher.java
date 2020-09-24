package com.study.microservices.patterns.service;

import com.study.microservices.patterns.event.DomainEvent;
import com.study.microservices.patterns.model.Order;

import java.util.List;
import java.util.function.Function;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:35
 * @changeRecord
 */
public class DomainEventPublisher {
    public void publish(Class<Order> orderClass, String toString, Order events) {

    }

    public <A> void publish(Class<A> aggregateType, Function<A, Object> idSupplier, Object apply, List<DomainEvent> events) {

    }
}
