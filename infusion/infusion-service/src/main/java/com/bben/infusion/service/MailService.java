//package com.bben.infusion.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import top.liankuan.quantity.util.mail.model.MailMessage;
//import top.liankuan.quantity.util.mail.model.SpecialMailMessage;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.UnsupportedEncodingException;
//import java.util.Properties;
//
//import static com.bben.infusion.controller.MailMQTest.QUEUE_NOTICE_MAIL_PLAIN;
//import static top.liankuan.quantity.util.mail.util.Const.QUEUE_NOTICE_MAIL_HTML;
//import static top.liankuan.quantity.util.mail.util.Const.QUEUE_NOTICE_MAIL_PLAIN;
//
//@Slf4j
//@Service
//public class MailService {
//
//    @Autowired
//    private JavaMailSenderImpl sender;
//
//    private JavaMailSenderImpl mailSender;
//
//    {
//        mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.exmail.qq.com");
//        mailSender.setUsername("write@liankuan.top");
//        mailSender.setPassword("Cqt2018");
//        mailSender.setPort(465);
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", true);
//        properties.put("mail.smtp.timeout", 5000);
//        properties.put("mail.smtp.starttls.enable", true);
//        properties.put("mail.smtp.starttls.required", true);
//        properties.put("mail.smtp.ssl.enable", true);
//        mailSender.setJavaMailProperties(properties);
//    }
//
//    @RabbitListener(queues = QUEUE_NOTICE_MAIL_PLAIN)
//    public void receive(MailMessage message) {
//        send(message);
//    }
//
//    private void send(MailMessage message) {
//        if (message.check()) {
//            SimpleMailMessage m = new SimpleMailMessage();
//            m.setFrom(sender.getUsername());
//            m.setTo(message.getReceives());
//            m.setSubject(message.getSubject());
//            m.setText(message.getText());
//            sender.send(m);
//            // TODO 保存到数据库里
//
//            log.info(getClass().getSimpleName() + " message --> " + message);
//            return;
//        }
//        log.error(getClass().getSimpleName() + " message --> " + message);
//    }
//
//    @RabbitListener(queues = QUEUE_NOTICE_MAIL_HTML)
//    public void receive(SpecialMailMessage message) {
//        send(message);
//    }
//
//    private void send(SpecialMailMessage message) {
//        MimeMessage m = sender.createMimeMessage();
//        if (message.check()) {
//            MimeMessageHelper helper = null;
//            try {
//                helper = new MimeMessageHelper(m, true);
//                helper.setFrom(sender.getUsername(), "BitcOPT币权");
//                helper.setSubject(message.getSubject());
//                helper.setTo(message.getReceives());
//                helper.setText(message.getMould(), true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            try {
//                sender.send(m);
//            } catch (Exception e) {
//                e.printStackTrace();
//                try {
//                    helper.setFrom(mailSender.getUsername(), "BitcOPT币权");
//                } catch (MessagingException e1) {
//                    e1.printStackTrace();
//                } catch (UnsupportedEncodingException e1) {
//                    e1.printStackTrace();
//                }
//                mailSender.send(m);
//            }
//            // TODO 保存到数据库里
//
//            log.info(getClass().getSimpleName() + " SpecialMailMessage --> " + message);
//            return;
//        }
//        log.error(getClass().getSimpleName() + " SpecialMailMessage --> " + message);
//    }
//
//}
