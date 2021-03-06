package com.study.microservices.patterns.service;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:38
 * @changeRecord
 */
public interface SimpleSage<T> {
    SagaDefinition<CreateOrderSagaState> getSagaDefinition();
}
