package com.newsoft.im.exception;

/**
 * @author
 * @create 2018-03-22 23:09
 * Description: 尚未登录异常
 */
public class NotLoggedException extends RuntimeException {
    static final long serialVersionUID = -878969878L;

    public NotLoggedException() {
        super();
    }

    public NotLoggedException(String message) {
        super(message);
    }

    public NotLoggedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoggedException(Throwable cause) {
        super(cause);
    }

    protected NotLoggedException(String message, Throwable cause,
                                 boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
