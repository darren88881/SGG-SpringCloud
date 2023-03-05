package com.itguigu.springcloud.service.impl;

import com.itguigu.springcloud.service.IMessageProviderService;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author darren
 * @EnableBinding(Source.class) 定义消息的推送管道 将Channel和Exchanges绑定在一起
 * @date 2023/03/05 13:35
 */
@EnableBinding(Source.class)
public class IMessageProviderServiceImpl implements IMessageProviderService {

    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        Message<String> stringMessage = MessageBuilder.withPayload(uuid).build();
        output.send(stringMessage);
        System.out.println("uuid："+ uuid);
        return uuid;
    }
}
