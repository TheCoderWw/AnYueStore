package com.springmvc.util;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Component
public class EmailUtils extends Thread {

    public void sendEmail(String address, String uuid) {
        Properties properties = new Properties();
        properties.setProperty("mail.host", "smtp.163.com");
        properties.setProperty("mail.smtp.auth", "true");
        //使用ssl证书,开放465端口
        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.smtp.socketFactory.port", "465");
        properties.setProperty("mail.smtp.port", "465");
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("18710800163", "ww04163054");
            }
        };
        //得到session
        Session session = Session.getInstance(properties, authenticator);
//        创建message
        MimeMessage mimeMessage = new MimeMessage(session);
        MimeMultipart mimeMultipart = new MimeMultipart();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        try {
//            mimeBodyPart.setContent("点击链接验证该邮箱" + "http://47.94.108.73:8080/ayms/user/verify/" + uuid, "text/html;charset=utf-8");
            mimeBodyPart.setContent("点击链接验证该邮箱" + "http://localhost:8080/user/verify/" + uuid, "text/html;charset=utf-8");

//            System.out.println(uuid);
            mimeMultipart.addBodyPart(mimeBodyPart);
            mimeMessage.setFrom(new InternetAddress("18710800163@163.com"));
            mimeMessage.setRecipients(Message.RecipientType.TO, address);
//            System.out.println(address);
            mimeMessage.setSubject("授权码");
            mimeMessage.setContent(mimeMultipart);
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}