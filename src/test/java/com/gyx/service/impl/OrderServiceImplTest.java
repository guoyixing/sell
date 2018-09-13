package com.gyx.service.impl;

import com.gyx.dataobject.OrderDetail;
import com.gyx.dto.OrderDTO;
import com.gyx.enums.OrderStatusEnum;
import com.gyx.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private IdServiceImpl idService;

    private final String BUYER_OPENID = "1101110";

    private final String ORDER_ID="1527662451744405385";
    @Test
    public void create() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("GYX");
        orderDTO.setBuyerAddress("南京市");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(2);
        orderDetailList.add(o1);
        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
        Assert.assertEquals(ORDER_ID,orderDTO.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest pageRequest = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID,pageRequest);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void addOrder() throws Exception {
        idService.save();
    }

//    @Test
//    public void cancel() throws Exception {
//        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//        OrderDTO result = orderService.cancel(orderDTO);
//        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
//    }

//    @Test
//    public void finish() throws Exception {
//        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//        OrderDTO result = orderService.finish(orderDTO);
//        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
//    }

//    @Test
//    public void paid() throws Exception {
//        OrderDTO orderDTO = orderService.findOne(ORDER_ID);
//        OrderDTO result = orderService.paid(orderDTO);
//        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getOrderStatus());
//    }

}