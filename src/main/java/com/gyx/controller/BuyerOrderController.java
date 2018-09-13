package com.gyx.controller;

import com.gyx.converter.OrderForm2OrderDTOConverter;
import com.gyx.dataobject.AuthResource;
import com.gyx.dto.OrderDTO;
import com.gyx.enums.ResultEnum;
import com.gyx.exception.SellException;
import com.gyx.form.OrderForm;
import com.gyx.service.AuthResourceService;
import com.gyx.service.BuyerService;
import com.gyx.service.OrderService;
import com.gyx.utils.ResultVOUtils;
import com.gyx.utils.TreeNode;
import com.gyx.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gyx
 * @date 2018-05-31 08:52
 * @since 1.0.0
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private AuthResourceService authResourceService;

    /**
     * 创建订单
     *
     * @author gyx
     * @date 2018/5/31 11:37
     * @since 1.0.0
     */
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("创建订单，参数不正确，orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                    , bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("创建订单，购物车为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResUlt = new OrderDTO();

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResUlt.getOrderId());
        return ResultVOUtils.success(map);
    }

    /**
     * 查询用户订单列表
     *
     * @author gyx
     * @date 2018/5/31 11:37
     * @since 1.0.0
     */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("查询订单列表,openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtils.success(orderDTOPage.getContent());
    }

    /**
     * 查询订单详情
     *
     * @author gyx
     * @date 2018/5/31 11:37
     * @since 1.0.0
     */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVOUtils.success(orderDTO);
    }

    /**
     * 取消订单
     *
     * @author gyx
     * @date 2018/5/31 11:41
     * @since 1.0.0
     */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVOUtils.success();
    }

    @GetMapping("/test")
    public List<TreeNode<AuthResource>> test() {
        List<TreeNode<AuthResource>> treeNodes = authResourceService.toTree();
        return treeNodes;
    }
}
