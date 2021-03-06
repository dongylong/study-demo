package com.study.microservices.patterns.handlers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author dongyl
 * @version 1.0
 * @title
 * @description
 * @company 好未来-爱智康
 * @created 2020/9/29 11:15
 * @changeRecord
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateItemSpec {
    private Map<String,String> withPrimaryKey;
    private String withUpdateExpression;
    private String withNameMap;
    private String withValueMap;
    private String withReturnValues;
}
