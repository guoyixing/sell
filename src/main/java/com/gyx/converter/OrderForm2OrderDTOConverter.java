package com.gyx.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gyx.dataobject.OrderDetail;
import com.gyx.dto.OrderDTO;
import com.gyx.enums.ResultEnum;
import com.gyx.exception.SellException;
import com.gyx.form.OrderForm;
import com.gyx.service.OrderService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyx
 * @date 2018-05-31 09:10
 * @since 1.0.0
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderDTO.getBuyerOpenid());

        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("对象转换错误，string = {}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
