package com.study.microservices.patterns.handlers;

import com.study.microservices.patterns.model.Order;

import java.util.Optional;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/29 10:58
 * @changeRecord
 */
public interface OrderHistoryDao {
    void addOrder(Order o, Optional<SourceEvent> eventSource);

    void addOrder(Order o, Order makeSourceEvent);

    void notePickedUp(String orderId, Optional<SourceEvent> eventSource);

    void notePickedUp(Long orderId);
}
