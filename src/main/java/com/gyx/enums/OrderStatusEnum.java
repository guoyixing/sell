package com.gyx.enums;

import lombok.Getter;

/**
 * @author gyx
 * @date 2018-05-29 15:09
 * @since 1.0.0
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
