package org.musix.box.notification.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.musix.box.notification.mail.enums.EmailType;
import org.musix.box.notification.mail.service.EmailService;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
public class KafkaListenerConfig {

    private EmailService emailService;

    public KafkaListenerConfig(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics="mail")
    public void orderListener(ConsumerRecord<Long, String> record){
        emailService.sendSimpleEmail("address", record.topic(), "link", EmailType.CONFIRM);
    }
}
