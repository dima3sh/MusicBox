package org.musix.box.notification.mail.service;

import org.musix.box.notification.mail.enums.EmailType;

public interface EmailService {

    void sendSimpleEmail(String toAddress, String subject, String link, EmailType type);
}
