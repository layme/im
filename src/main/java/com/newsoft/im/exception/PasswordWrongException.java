package com.newsoft.im.exception;

/**
 * @author
 * @create 2018-03-22 23:09
 * Description: 密码错误异常
 */
public class PasswordWrongException extends RuntimeException {
    static final long serialVersionUID = -878969878L;

    public PasswordWrongException() {
        super();
    }

    public PasswordWrongException(String message) {
        super(message);
    }

    public PasswordWrongException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordWrongException(Throwable cause) {
        super(cause);
    }

    protected PasswordWrongException(String message, Throwable cause,
                                     boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
