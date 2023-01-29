package org.music.box.external.controller.configuration.music.playlist.configuration.enums;

public enum RabbitType {
    PLAYLIST("abacaba");

    private String name;

    RabbitType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}