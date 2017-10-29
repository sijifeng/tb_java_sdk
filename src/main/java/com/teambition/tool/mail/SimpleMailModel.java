package com.teambition.tool.mail;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * Created by yingchun on 2017/10/27.
 */
public class SimpleMailModel implements MailModel, Serializable {
    private String from;

    private String replyTo;

    private String[] to;

    private String[] cc;

    private String[] bcc;

    private Date sentDate;

    private String subject;

    private String text;


    /**
     * Create a new {@code SimpleMailMessage}.
     */
    public SimpleMailModel() {
    }

    /**
     * Copy constructor for creating a new {@code SimpleMailMessage} from the state
     * of an existing {@code SimpleMailMessage} instance.
     *
     * @throws IllegalArgumentException if the supplied message is {@code null}
     */
    public SimpleMailModel(SimpleMailModel original) {
        Objects.requireNonNull(original, "The 'original' message argument cannot be null");
        this.from = original.getFrom();
        this.replyTo = original.getReplyTo();
        if (original.getTo() != null) {
            this.to = copy(original.getTo());
        }
        if (original.getCc() != null) {
            this.cc = copy(original.getCc());
        }
        if (original.getBcc() != null) {
            this.bcc = copy(original.getBcc());
        }
        this.sentDate = original.getSentDate();
        this.subject = original.getSubject();
        this.text = original.getText();
    }


    @Override
    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return this.from;
    }

    @Override
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    public String getReplyTo() {
        return replyTo;
    }

    @Override
    public void setTo(String to) {
        this.to = new String[]{to};
    }

    @Override
    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getTo() {
        return this.to;
    }

    @Override
    public void setCc(String cc) {
        this.cc = new String[]{cc};
    }

    @Override
    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getCc() {
        return cc;
    }

    @Override
    public void setBcc(String bcc) {
        this.bcc = new String[]{bcc};
    }

    @Override
    public void setBcc(String[] bcc) {
        this.bcc = bcc;
    }

    public String[] getBcc() {
        return bcc;
    }

    @Override
    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Date getSentDate() {
        return sentDate;
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }


    /**
     * Copy the contents of this message to the given target message.
     *
     * @param target the {@code MailMessage} to copy to
     * @throws IllegalArgumentException if the supplied {@code target} is {@code null}
     */
    public void copyTo(MailModel target) {
        Objects.requireNonNull(target, "The 'target' message argument cannot be null");
        if (getFrom() != null) {
            target.setFrom(getFrom());
        }
        if (getReplyTo() != null) {
            target.setReplyTo(getReplyTo());
        }
        if (getTo() != null) {
            target.setTo(getTo());
        }
        if (getCc() != null) {
            target.setCc(getCc());
        }
        if (getBcc() != null) {
            target.setBcc(getBcc());
        }
        if (getSentDate() != null) {
            target.setSentDate(getSentDate());
        }
        if (getSubject() != null) {
            target.setSubject(getSubject());
        }
        if (getText() != null) {
            target.setText(getText());
        }
    }


    @Override
    public int hashCode() {
        int hashCode = (this.from == null ? 0 : this.from.hashCode());
        hashCode = 29 * hashCode + (this.replyTo == null ? 0 : this.replyTo.hashCode());
        for (int i = 0; this.to != null && i < this.to.length; i++) {
            hashCode = 29 * hashCode + (this.to == null ? 0 : this.to[i].hashCode());
        }
        for (int i = 0; this.cc != null && i < this.cc.length; i++) {
            hashCode = 29 * hashCode + (this.cc == null ? 0 : this.cc[i].hashCode());
        }
        for (int i = 0; this.bcc != null && i < this.bcc.length; i++) {
            hashCode = 29 * hashCode + (this.bcc == null ? 0 : this.bcc[i].hashCode());
        }
        hashCode = 29 * hashCode + (this.sentDate == null ? 0 : this.sentDate.hashCode());
        hashCode = 29 * hashCode + (this.subject == null ? 0 : this.subject.hashCode());
        hashCode = 29 * hashCode + (this.text == null ? 0 : this.text.hashCode());
        return hashCode;
    }


    private static String[] copy(String[] state) {
        String[] copy = new String[state.length];
        System.arraycopy(state, 0, copy, 0, state.length);
        return copy;
    }
}
