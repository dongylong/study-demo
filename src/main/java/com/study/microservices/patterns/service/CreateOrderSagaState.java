package com.study.microservices.patterns.service;

import com.study.microservices.patterns.model.CancelCreateTicket;
import com.study.microservices.patterns.model.CreateTicket;
import com.study.microservices.patterns.model.CreateTicketReply;
import com.study.microservices.patterns.model.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:12
 * @changeRecord
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CreateOrderSagaState {
    private Long orderId;
    private OrderDetails orderDetails;
    private long ticketId;

    public CreateOrderSagaState(Long id, OrderDetails orderDetails) {

    }


    CreateTicket makeCreateTicketCommand() {
        return new CreateTicket(getOrderDetails().getRestaurantId(),getOrderId(),makeTicketDetails(getOrderDetails()));
    }

    void handleCreateTicketReply(CreateTicketReply createTicketReply) {
        Long ticketId = createTicketReply.getTicketId();
        log.warn("ticketId:{}",ticketId);
        setTicketId(ticketId);
    }

    CancelCreateTicket makeCancelCreateTicketCommand() {
        return new CancelCreateTicket(getOrderId());
    }

    private OrderDetails makeTicketDetails(OrderDetails orderDetails) {
        return null;
    }
}
