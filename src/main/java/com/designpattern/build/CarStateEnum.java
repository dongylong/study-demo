package com.designpattern.build;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author dongyl
 * @date 20:04 1/9/19
 * @project study-demo
 */
@AllArgsConstructor
@NoArgsConstructor
public enum  CarStateEnum {
    CAR_START("start"),
    CAR_STOP("stop"),
    CAR_ALARM("alarm"),
    CAR_ENGINE_BOOM("boom");

    @Getter
    private String code;
}
