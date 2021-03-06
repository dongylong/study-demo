package com.study.microservices.patterns.model;

import com.study.microservices.patterns.service.ResultWithEvents;
import javafx.event.Event;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.study.microservices.patterns.model.OrderState.APPROVAL_PENDING;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:27
 * @changeRecord
 */
@Data
@NoArgsConstructor
public class Order {
    private Long id;
    private OrderState state;
    private Long consumerId;
    private Long restaurantId;
    private OrderLineItems orderLineItems;
    private DeliveryInformation deliveryInformation;
    private PaymentInformation paymentInformation;
    private Money orderMinimum;

    public List<Event> process(CreateOrderCommand command) {
        //validate command
        return events(new OrderCreatedEvent(command.getOrderDetails()));

    }

    public void apply(OrderCreatedEvent event) {
        OrderDetails orderDetails = event.getOrderDetails();
        this.orderLineItems = new OrderLineItems(orderDetails.getLineItems());
        this.state = APPROVAL_PENDING;
    }

    private List<Event> events(OrderCreatedEvent orderCreatedEvent) {
        return null;
    }

    public static ResultWithEvents<Order> createOrder() {
        return null;
    }
}
