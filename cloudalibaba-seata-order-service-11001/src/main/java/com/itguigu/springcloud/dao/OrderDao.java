package com.itguigu.springcloud.dao;

import com.itguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @Author darren
 * @Date 2023/3/14 21:00
 */
@Mapper
public interface OrderDao {
    //1 新建订单
    void create(Order order);

    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("statusNum") Integer statusNum);

    Order selectById(Long id);
}
