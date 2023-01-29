package org.music.box.external.controller.configuration.music.playlist.configuration.enums;

public enum RabbitMethod {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE");

    private String name;

    RabbitMethod(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}