package com.teambition.tool.mail;

/**
 * Created by yingchun on 2017/10/27.
 */
public abstract class MailException extends RuntimeException {
    /**
     * Constructor for MailException.
     *
     * @param msg the detail message
     */
    public MailException(String msg) {
        super(msg);
    }

    /**
     * Constructor for MailException.
     *
     * @param msg   the detail message
     * @param cause the root cause from the mail API in use
     */
    public MailException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
