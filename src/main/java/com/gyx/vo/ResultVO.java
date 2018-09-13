package com.gyx.vo;

import lombok.Data;

/**
 * http请求返回的对象
 * @author gyx
 * @date 2018-05-29 11:29
 * @since 1.0.0
 */
@Data
public class ResultVO<T> {

    /**
     * 错误代码
     */
    private Integer code;

    /**
     * 提示消息
     */
    private String msg;

    /**
     * 返回的数据
     */
    private T data;
}
