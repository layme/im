package com.newsoft.im.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author
 * @create 2018-03-21 17:18
 * Description: 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class ResultExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    public <T> RestResult<T> exceptionHandler(Exception e) {
        log.error("meet an Exception: " + e);
        return RestResultGenerator.genErrorResult(e.getMessage());
    }
}
