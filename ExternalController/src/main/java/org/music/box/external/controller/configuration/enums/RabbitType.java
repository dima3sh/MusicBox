package org.music.box.external.controller.configuration.enums;

public enum RabbitType {
    PLAYLIST("PLAYLIST");

    private String name;

    RabbitType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}