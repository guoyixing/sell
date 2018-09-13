package com.gyx.dto;

import lombok.Data;

/**
 * 购物车
 *
 * @author gyx
 * @date 2018-05-30 14:08
 * @since 1.0.0
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
