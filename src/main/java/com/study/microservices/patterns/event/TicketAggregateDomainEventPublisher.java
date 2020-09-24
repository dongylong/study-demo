package com.study.microservices.patterns.event;

import com.study.microservices.patterns.model.Ticket;
import com.study.microservices.patterns.service.DomainEventPublisher;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/27 15:13
 * @changeRecord
 */
public class TicketAggregateDomainEventPublisher extends AbstractAggregateDomainEventPublisher {

    public TicketAggregateDomainEventPublisher(DomainEventPublisher eventPublisher){
        super(eventPublisher, Ticket.class, Ticket::getId);
    }
}
