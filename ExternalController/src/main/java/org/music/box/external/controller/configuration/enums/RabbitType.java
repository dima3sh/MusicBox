package org.music.box.external.controller.configuration.enums;

public enum RabbitType {
    PLAYLIST("PLAYLIST"),
    SONG("SONG");

    private String name;

    RabbitType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}