package com.gyx.controller;

import com.gyx.dto.OrderDTO;
import com.gyx.enums.ResultEnum;
import com.gyx.exception.SellException;
import com.gyx.service.OrderService;
import com.gyx.service.PayService;
import com.lly835.bestpay.model.PayRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 支付
 *
 * @author gyx
 * @date 2018-06-04 10:16
 * @since 1.0.0
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl")String returnUrl,
                               Map<String,Object> map){
        //查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //
        PayRequest payRequest = payService.create(orderDTO);
        map.put("payRequest",payRequest);
        return new ModelAndView("pay/create",map);
    }

    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData){
        payService.notify(notifyData);
        //返回结果给微信
        return new ModelAndView("pay/success");
    }
}
