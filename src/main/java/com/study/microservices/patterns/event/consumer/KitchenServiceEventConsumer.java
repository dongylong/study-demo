package com.study.microservices.patterns.event.consumer;

import com.study.microservices.patterns.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/27 15:53
 * @changeRecord
 */
public class KitchenServiceEventConsumer {
    @Autowired
    private RestaurantService restaurantService;

    /**
     * 把事件映射事件处理程序
     * @return
     */
    public DomainEventHandlers domainEventHandlers(){
        return DomainEventHandlersBuilder
                .forAggregateType()
                .onEvent(RestaurantMenuRevised.class,this.reviseMenu)
                .build();
    }

    /**
     * RestaurantMenuRevised 事件处理程序
     * @param de
     */
    public void reviseMenu(DomainEventEnvelope<RestaurantMenuRevised> de){
        long id = Long.parseLong(de.getAggregateId());
        RestaurantMenu revisedMenu = de.getEvent().getRevisedMenu();
        restaurantService.reviseMenu(id,revisedMenu);

    }


}
