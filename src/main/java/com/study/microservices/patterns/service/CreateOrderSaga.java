package com.study.microservices.patterns.service;

import com.study.microservices.patterns.proxy.AccountServiceProxy;
import com.study.microservices.patterns.proxy.ConsumerServiceProxy;
import com.study.microservices.patterns.proxy.KitchenServiceProxy;
import com.study.microservices.patterns.proxy.OrderServiceProxy;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:12
 * @changeRecord
 */
public class CreateOrderSaga implements SimpleSage<CreateOrderSagaState>{

    private SagaDefinition<CreateOrderSagaState> sagaDefinition;

    public CreateOrderSaga(OrderServiceProxy orderService,
                           ConsumerServiceProxy consumerService,
                           KitchenServiceProxy kitchenService,
                           AccountServiceProxy accountService

    ){
        this.sagaDefinition =
                step()
                .withCompensation(orderService.reject,CreateOrderSagaState::makeRejectOrderCommand)
                .build();
    }

    @Override
    public SagaDefinition<CreateOrderSagaState> getSagaDefinition(){
        return sagaDefinition;
    }
}
