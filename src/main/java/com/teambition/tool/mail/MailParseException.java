package com.teambition.tool.mail;

/**
 * Created by yingchun on 2017/10/27.
 */
public class MailParseException extends MailException {
    /**
     * Constructor for MailParseException.
     *
     * @param msg the detail message
     */
    public MailParseException(String msg) {
        super(msg);
    }

    /**
     * Constructor for MailParseException.
     *
     * @param msg   the detail message
     * @param cause the root cause from the mail API in use
     */
    public MailParseException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Constructor for MailParseException.
     *
     * @param cause the root cause from the mail API in use
     */
    public MailParseException(Throwable cause) {
        super("Could not parse mail", cause);
    }
}
