package com.study.microservices.patterns.event;

import com.study.microservices.patterns.service.DomainEventPublisher;

import java.util.List;
import java.util.function.Function;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/27 15:13
 * @changeRecord
 */
public class AbstractAggregateDomainEventPublisher<A, E extends DomainEvent> {
    private Function<A, Object> idSupplier;
    private DomainEventPublisher eventPublisher;
    private Class<A> aggregateType;

    public AbstractAggregateDomainEventPublisher(
            DomainEventPublisher eventPublisher,
            Class<A> aggregateType,
            Function<A, Object> idSupplier
    ) {
        this.idSupplier = idSupplier;
        this.eventPublisher = eventPublisher;
        this.aggregateType = aggregateType;
    }

    public void publish(A aggregate, List<E> events) {
        eventPublisher.publish(aggregateType, idSupplier, idSupplier.apply(aggregate), (List<DomainEvent>) events);
    }
}
