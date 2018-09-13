package com.gyx.repository;

import com.gyx.dataobject.OrderDetail;
import com.gyx.vo.ProductInfoVO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void save(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456788");
        orderDetail.setOrderId("1111111");
        orderDetail.setProductId("11111112");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(2);
        OrderDetail save = repository.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrOrderId() throws Exception {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("1111112");
        Assert.assertNotEquals(0,orderDetailList.size());
    }

    public void test(){
        List<ProductInfoVO> vo = new ArrayList<>();
        for (ProductInfoVO productInfoVO : vo) {
            System.out.println(productInfoVO.toString());
        }
    }

}