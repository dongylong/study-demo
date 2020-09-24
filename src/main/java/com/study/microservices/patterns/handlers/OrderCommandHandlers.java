package com.study.microservices.patterns.handlers;

import com.study.microservices.patterns.service.OrderService;
import com.sun.corba.se.impl.activation.CommandHandler;

import javax.annotation.Resource;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/25 09:45
 * @changeRecord
 */
public class OrderCommandHandlers {
    @Resource
    private OrderService orderService;

    public CommandHandler commandHandler(){
        return SagaCommandHandlersBuilder.fromChannel("orderService")
                .onMessage(ApproveOrderCommand.class,this::approveOrder)
                .onMessage(RejectOrderCommand.class,this::rejectOrder)
                .build();
    }
    public Message approveOrder(CommandMessage<ApproveOrderCommand> cm){
        return new Message();
    }
    public Message rejectOrder(){
        return new Message();
    }
}
