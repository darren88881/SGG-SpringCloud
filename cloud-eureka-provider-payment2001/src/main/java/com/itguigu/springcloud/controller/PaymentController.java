package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.entities.CommonResult;
import com.itguigu.springcloud.entities.Payment;
import com.itguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:39
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment){
        int result = paymentService.addPayment(payment);
        if (result > 0) {
            return new CommonResult<Payment>(200, "add payment success");
        } else {
          return new CommonResult<Payment>(444, "add payment fail");
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        return new CommonResult<Payment>(200,"select payment success port:" + serverPort, payment);
    }

    /**
     * 服务发现Discovery
     * @return
     */
    @GetMapping("/discovery")
    public Object getDiscovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach( service ->{
            log.info("service:"+service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-EUREKA-PROVIDER-PAYMENT");
        instances.forEach(instance ->{
            log.info(
                    instance.getServiceId()+" "+
                    instance.getHost()+" "+
                    instance.getPort()+" "+
                    instance.getUri()
            );
        });
        return this.discoveryClient;
    }

    @GetMapping("/timeout")
    public String getPaymentTimeout() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return serverPort;
    }

    @GetMapping("/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
