package com.study.microservices.patterns.service;

import com.study.microservices.patterns.model.Ticket;
import com.study.microservices.patterns.model.TicketDomainEvent;

import javax.annotation.Resource;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 16:40
 * @changeRecord
 */
public class KitchenService {

    @Resource
    private TicketRepository ticketRepository;

    @Resource
    private TicketDomainEventPublisher domainEventPublisher;

    public void accept(long ticketId, ZonedDateTime readyBy) {
//        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(()->new TicketNotFoundException(ticketId));
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException(ticketId + ""));
        List<TicketDomainEvent> events = ticket.accept(readyBy);
        domainEventPublisher.publish(ticket,events);
    }
}
