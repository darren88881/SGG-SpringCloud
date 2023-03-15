package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.domain.CommonResult;
import com.itguigu.springcloud.service.OrderService;
import com.itguigu.springcloud.domain.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:27
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }

    @GetMapping("/order/selectById")
    public CommonResult selectById(Long id) {
        Order order = orderService.selectById(id);
        return new CommonResult(200, "查询订单成功", order);
    }
}
