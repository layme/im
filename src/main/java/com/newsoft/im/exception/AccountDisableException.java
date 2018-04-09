package com.newsoft.im.exception;

/**
 * @author
 * @create 2018-03-22 23:09
 * Description: 账号冻结异常
 */
public class AccountDisableException extends RuntimeException {
    static final long serialVersionUID = -878969878L;

    public AccountDisableException() {
        super();
    }

    public AccountDisableException(String message) {
        super(message);
    }

    public AccountDisableException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDisableException(Throwable cause) {
        super(cause);
    }

    protected AccountDisableException(String message, Throwable cause,
                                      boolean enableSuppression,
                                      boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
