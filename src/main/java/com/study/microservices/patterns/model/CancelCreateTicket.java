package com.study.microservices.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/24 17:02
 * @changeRecord
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelCreateTicket {
    private Long orderId;
}
