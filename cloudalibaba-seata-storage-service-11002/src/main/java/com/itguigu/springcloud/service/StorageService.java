package com.itguigu.springcloud.service;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:42
 */
public interface StorageService {
    public void decrease(Long productId, Integer count);
}
