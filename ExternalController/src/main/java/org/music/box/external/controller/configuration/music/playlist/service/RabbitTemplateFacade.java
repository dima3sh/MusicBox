package org.music.box.external.controller.configuration.music.playlist.service;

import org.music.box.external.controller.configuration.music.playlist.configuration.enums.RabbitMethod;
import org.music.box.external.controller.configuration.music.playlist.configuration.enums.RabbitType;

public interface RabbitTemplateFacade {

    <T> T sendMessageAndReceive(RabbitMethod method, RabbitType type, Object obj, T clazz);
}
