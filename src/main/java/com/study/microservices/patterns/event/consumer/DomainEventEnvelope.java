package com.study.microservices.patterns.event.consumer;

import lombok.Data;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/27 15:57
 * @changeRecord
 */
@Data
public class DomainEventEnvelope<T> {
    private String aggregateId;
    private T event;

}
