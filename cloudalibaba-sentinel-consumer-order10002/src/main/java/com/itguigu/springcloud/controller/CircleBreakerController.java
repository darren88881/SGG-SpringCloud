package com.itguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/3/13 12:35
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class CircleBreakerController {

    @Value("${service-url.nacos-user-service}")
    private String SERVICE_URL;

    @Resource
    private RestTemplate restTemplate;

    /**
     * fallback    ：若本接口出现未知异常，则调用fallback指定的接口。
     * blockHandler：若本次访问被限流或服务降级，则调用blockHandler指定的接口。
     * @param id
     * @return
     */
    @RequestMapping("/paymentSQL/{id}")
    @SentinelResource(value = "paymentSQL",fallback = "fallback_method",blockHandler =
            "blockHandler")
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);

        if (result.getData() == null) {
            throw new NullPointerException("非法参数异常");
        }

        return result;
    }

    /**
     * fallback ：若本接口出现未知异常，则调用fallback指定的接口。
     * @param id
     * @param e
     * @return
     */
    public CommonResult fallback_method(@PathVariable Long id, Throwable e) {
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "未知异常兜底,exception内容：" + e.getMessage(),
                payment);
    }

    /**
     * blockHandler：若本次访问被限流或服务降级，则调用blockHandler指定的接口。
     * @param id
     * @param exception
     * @return
     */
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException exception) {
        Payment payment = new Payment(id,"null");
        return new CommonResult(445,"限流降级兜底,exception内容"+exception.getMessage(),payment);
    }

}
