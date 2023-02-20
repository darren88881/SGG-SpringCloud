package com.itguigu.springcloud.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @Author darren
 * @Date 2023/2/20 11:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private int code;
    private String massage;
    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
