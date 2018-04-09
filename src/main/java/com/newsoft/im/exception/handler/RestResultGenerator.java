package com.newsoft.im.exception.handler;

/**
 * @author
 * @create 2018-03-21 17:08
 * Description: 返回结果生成器
 */
public class RestResultGenerator {
    /**
     * 生成返回对象的一般格式
     * @param result
     * @param data
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genResult(boolean result, T data, String message) {
        RestResult<T> restResult = RestResult.newInstance();
        restResult.setResult(result);
        restResult.setData(data);
        restResult.setMessage(message);
        return restResult;
    }

    /**
     * 成功时的返回格式
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genSuccessResult(T data) {
        return genResult(true, data, null);
    }

    /**
     * 失败时的返回格式
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResult<T> genErrorResult(String message) {
        return genResult(false, null, message);
    }
}
