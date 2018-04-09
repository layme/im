package com.newsoft.im.exception;

/**
 * @author
 * @create 2018-03-22 23:09
 * Description: 非法操作异常
 */
public class IllegalOperationException extends RuntimeException {
    static final long serialVersionUID = -878969878L;

    public IllegalOperationException() {
        super();
    }

    public IllegalOperationException(String message) {
        super(message);
    }

    public IllegalOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOperationException(Throwable cause) {
        super(cause);
    }

    protected IllegalOperationException(String message, Throwable cause,
                                        boolean enableSuppression,
                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
