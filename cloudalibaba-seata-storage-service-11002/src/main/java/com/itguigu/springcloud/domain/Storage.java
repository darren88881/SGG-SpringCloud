package com.itguigu.springcloud.domain;

import lombok.Data;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:42
 */
@Data
public class Storage {
    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}
