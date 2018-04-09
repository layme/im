package com.newsoft.im.exception.handler;

import lombok.Data;

/**
 * @author
 * @create 2018-03-21 17:04
 * Description: 统一返回该对象给前端，data携带具体数据
 */
@Data
public class RestResult<T> {
    private boolean result;
    private String message;
    private T data;

    private RestResult() {}

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }
}
