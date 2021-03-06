package com.study.microservices.patterns.handlers;

import com.study.microservices.patterns.model.Order;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.study.microservices.patterns.handlers.DeliveryStatus.DELIVERY_STATUS_FIELD;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/29 10:58
 * @changeRecord
 */
public class OrderHistoryDaoDynamoDb implements OrderHistoryDao{

    @Override
    public void addOrder(Order o, Optional<SourceEvent> eventSource) {

    }

    @Override
    public void addOrder(Order o, Order makeSourceEvent) {

    }
    @Override
    public void notePickedUp(String orderId, Optional<SourceEvent> eventSource) {
        UpdateItemSpec spec =  UpdateItemSpec.builder()
                .withPrimaryKey("orderId",orderId)
                .withUpdateExpression("SET #deliveryStatus = :deliveryStatus")
                .withNameMap(Collections.singletonMap("#deliveryStatus = :deliveryStatus",DELIVERY_STATUS_FIELD)
                .withValueMap(Collections.singletonMap("#deliveryStatus = :deliveryStatus",DeliveryStatus.PICKED_UP.toString())
                .withReturnValue(ReturnValue.NONE)
                .build();


    }

    @Override
    public void notePickedUp(Long orderId) {

    }
}
