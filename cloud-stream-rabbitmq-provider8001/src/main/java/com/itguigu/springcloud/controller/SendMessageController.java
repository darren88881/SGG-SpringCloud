package com.itguigu.springcloud.controller;

import com.itguigu.springcloud.service.IMessageProviderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 * @Author darren
 * @Date 2023/3/5 10:21
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProviderService messageProviderService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage() {
        return "已发送："+messageProviderService.send();
    }
}
