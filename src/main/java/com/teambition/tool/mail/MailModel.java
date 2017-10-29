package com.teambition.tool.mail;

import java.util.Date;

/**
 * Created by yingchun on 2017/10/27.
 */
public interface MailModel {
    public void setFrom(String from) throws MailParseException;

    public void setReplyTo(String replyTo) throws MailParseException;

    public void setTo(String to) throws MailParseException;

    public void setTo(String[] to) throws MailParseException;

    public void setCc(String cc) throws MailParseException;

    public void setCc(String[] cc) throws MailParseException;

    public void setBcc(String bcc) throws MailParseException;

    public void setBcc(String[] bcc) throws MailParseException;

    public void setSentDate(Date sentDate) throws MailParseException;

    public void setSubject(String subject) throws MailParseException;

    public void setText(String text) throws MailParseException;
}
