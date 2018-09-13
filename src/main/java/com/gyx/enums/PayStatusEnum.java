package com.gyx.enums;

import lombok.Getter;

/**
 * @author gyx
 * @date 2018-05-29 15:09
 * @since 1.0.0
 */
@Getter
public enum PayStatusEnum implements CodeEnum{
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功");

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
