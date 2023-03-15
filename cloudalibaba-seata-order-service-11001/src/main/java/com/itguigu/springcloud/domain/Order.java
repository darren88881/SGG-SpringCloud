package com.itguigu.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer countNum;

    private BigDecimal money;

    private Integer statusNum; //订单状态：0：创建中；1：已完结
}
