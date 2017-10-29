package com.teambition.tool.mail;


import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by yingchun on 2017/10/27.
 */
public class MailMessage {
    private static final String exmail = "smtp.qq.com";

    private String username = null;
    private String password = null;

    public MailMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void send(String subject, String msg, String[] targetMail) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(exmail);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        email.setFrom(username);
        for (String target : targetMail) {
            email.addTo(target);
        }

        email.setSubject(subject);
        email.setCharset("utf-8");
        email.setMsg(msg);
        email.send();
    }


    public void send(SimpleMailModel simpleMailModel) throws EmailException {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(exmail);
        email.setAuthentication(username, password);
        email.setSSLOnConnect(true);
        email.setFrom(username);
        for (String target : simpleMailModel.getTo()) {
            email.addTo(target);
        }

        if (null != simpleMailModel.getCc()) {
            for (String cc : simpleMailModel.getCc()) {
                email.addCc(cc);
            }
        }

        if (null != simpleMailModel.getBcc()) {
            for (String bcc : simpleMailModel.getBcc()) {
                email.addBcc(bcc);
            }
        }
        email.setSubject(simpleMailModel.getSubject());
        email.setCharset("utf-8");
        email.setMsg(simpleMailModel.getText());
        email.send();
    }
}
