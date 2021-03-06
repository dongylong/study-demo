package com.study.microservices.patterns.model;

import lombok.Data;
import lombok.SneakyThrows;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

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
public class Ticket {
    private Long id;
    private TicketState state;
    private Long restaurantId;

    private List<TicketLineItem> lineItems;

    private ZonedDateTime readyBy;
    private ZonedDateTime acceptTime;
    private ZonedDateTime preparingTime;
    private ZonedDateTime picketUpTime;
    private ZonedDateTime readyForPickUpTime;

    public Ticket(Long id, TicketDetail details) {

    }

    public static ResultWithAggregateEvents<Ticket, TicketDomainEvent> create(Long id, TicketDetail details) {
        return new ResultWithAggregateEvents<>(new Ticket(id, details), new TicketCreatedEvent(id, details));
    }

    public List<TicketPreparationStartedEvent> preparing() {
        switch (state) {
            case ACCEPTED:
                this.state = TicketState.PREPARING;
                this.preparingTime = ZonedDateTime.now();
                return Collections.singletonList(new TicketPreparationStartedEvent());
            default:
                throw new RuntimeException(state + "");
        }
    }
    @SneakyThrows
    public List<TicketPreparationStartedEvent> cancel() {
        switch (state) {
            case CREATED:
            case ACCEPTED:
                this.state = TicketState.CANCELED;
            case READY_FOR_PICKUP:
                throw new TicketCannotBeCancelledException();

            default:
                throw new RuntimeException(state + "");
        }
    }

    public List<TicketDomainEvent> accept(ZonedDateTime readyBy) {
        return null;
    }
}
