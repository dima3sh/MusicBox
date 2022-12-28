package org.musix.box.notification.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.musix.box.notification.mail.enums.EmailType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;

@Service
public class EmailSenderServiceImpl implements EmailService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String mailServerUsername;

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender emailSender,
                                  SpringTemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void sendSimpleEmail(String toAddress, String subject, String link, EmailType type) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.setFrom(mailServerUsername);
            helper.setTo(toAddress);
            helper.setSubject(subject);
            Context context = new Context();
            context.setVariable("link", link);
            String template = templateEngine.process(type.getTemplate(), context);
            helper.setText(template, true);
            emailSender.send(message);
        } catch (MailException | MessagingException exception) {
            exception.printStackTrace();
        }
    }

    @KafkaListener(topics="mail", containerFactory = "singleFactory")
    public void orderListener(ConsumerRecord<Long, String> record){
        System.out.println("hello");//todo rewrite
    }
}
