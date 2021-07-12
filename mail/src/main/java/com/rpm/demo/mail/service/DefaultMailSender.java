package com.rpm.demo.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author: Piming Ren
 * @date: 2021/6/16 18:07
 * @version: 1.0
 * @description:
 */
@Component
public class DefaultMailSender {

    private JavaMailSenderImpl mailSender;
    @Autowired
    DefaultMailSender(JavaMailSenderImpl mailSender){
        this.mailSender = mailSender;
    }

    /**
     * 简单发送 。
     * todo 进行一写参数重写
     */
    public void send() {
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        //邮件主提
        templateMessage.setSubject("the title subject of an email!");
        //发送人。不知道为啥要填这个。不是已经在配置文件里写了么
        templateMessage.setFrom("任丕明");
        //接受人。可以是多个人
        templateMessage.setTo("xxx@xxx.com");
        //抄送人。可以是多个人
        templateMessage.setBcc("xxx@xxx.com");
        //暗抄送。可以是多个人，不显示在抄送栏中
        templateMessage.setCc("xxx@xxx.com");
        //邮件内容。可以在后面增加签名信息
        templateMessage.setText("<p>this is text content</p>");
        mailSender.send(templateMessage);

    }

    /**
     * 另一种发送方式。
     */
    public void sendMime() {
        MimeMessage message = mailSender.createMimeMessage();

         // use the true flag to indicate you need a multipart message
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setTo("XXX@XXX.com");
            helper.setSubject("一个富文本的主题");
            helper.setCc("xxx@xxx.com");

            String text  = HtmlBuilder.create().text("都是好朋友").html();
            helper.setText(text, true);
            //附件
            FileSystemResource file = new FileSystemResource(new File("D:\\data\\把文件变小一点.doc"));
            helper.addAttachment("把文件变小一点", file);
            // let's include the infamous windows Sample file (this time copied to c:/)
            // 这里也就事放个图
            FileSystemResource res = new FileSystemResource(new File("D:\\data\\htcf.jpg"));
            helper.addInline("logo", res);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        mailSender.send(message);


    }


    public static void main(String[] args) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        host: smtp.263.net
//        port: 25
//        username: xxx@xxx.com
//        password: "******"
//        protocol: smtp
        sender.setHost("smtp.263.net");
        sender.setPort(25);
        sender.setUsername("renpiming@chtwm.com");
        sender.setPassword("");
        sender.setProtocol("smtp");
        sender.setDefaultEncoding("UTF-8");
        SimpleMailMessage templateMessage = new SimpleMailMessage();
        //邮件主提
        templateMessage.setSubject("the title subject of an email!");
        //发送人。不知道为啥要填这个。不是已经在配置文件里写了么
        templateMessage.setFrom("任丕明");
        //接受人。可以是多个人
        templateMessage.setTo("jhon_smith@163.com");
        //邮件内容。可以在后面增加签名信息
        templateMessage.setText("<p>this is text content</p>");
        sender.send(templateMessage);
    }
}
