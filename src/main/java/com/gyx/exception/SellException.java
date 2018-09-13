package com.gyx.exception;

import com.gyx.enums.ResultEnum;

/**
 * @author gyx
 * @date 2018-05-30 13:36
 * @since 1.0.0
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code, String msg) {
        super(msg);
        this.code=code;
    }
}
