package com.study.microservices.patterns.model;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/27 16:21
 * @changeRecord
 */
public class UnsupportedStateTransitionException extends Throwable {
    public UnsupportedStateTransitionException(TicketState state) {
    }
}
