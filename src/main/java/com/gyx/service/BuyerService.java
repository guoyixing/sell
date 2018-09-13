package com.gyx.service;

import com.gyx.dto.OrderDTO;

/**
 * 买家
 *
 * @author gyx
 * @date 2018-05-31 11:43
 * @since 1.0.0
 */
public interface BuyerService {
    /**
     * 查询一个订单
     */
    OrderDTO findOrderOne(String openid,String orderId);
    /**
     * 取消一个订单
     */
    OrderDTO cancelOrder(String openid,String orderId);
}
