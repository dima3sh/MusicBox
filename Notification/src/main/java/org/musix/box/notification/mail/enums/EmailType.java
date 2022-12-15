package org.musix.box.notification.mail.enums;

public enum EmailType {
    CONFIRM("confirm-registration.html"),
    RESTORE("restore-access.html");

    private final String template;

    EmailType(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
