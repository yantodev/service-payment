package com.yantodev.transaksi.util;

@Deprecated
public class ServiceException extends Exception {
    private static final long serialVersionUID = -7697643370872599673L;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
