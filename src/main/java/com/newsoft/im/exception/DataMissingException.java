package com.newsoft.im.exception;

/**
 * @author
 * @create 2018-03-22 23:09
 * Description: 数据丢失异常
 */
public class DataMissingException extends RuntimeException {
    static final long serialVersionUID = -878969878L;

    public DataMissingException() {
        super();
    }

    public DataMissingException(String message) {
        super(message);
    }

    public DataMissingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataMissingException(Throwable cause) {
        super(cause);
    }

    protected DataMissingException(String message, Throwable cause,
                                   boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
