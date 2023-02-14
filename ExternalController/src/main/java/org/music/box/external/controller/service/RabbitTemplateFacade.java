package org.music.box.external.controller.service;

import org.music.box.external.controller.configuration.enums.RabbitMethod;
import org.music.box.external.controller.configuration.enums.RabbitType;
import org.springframework.core.ParameterizedTypeReference;

public interface RabbitTemplateFacade {

    <T> T sendMessageAndReceive(RabbitMethod method, RabbitType type, Object obj, ParameterizedTypeReference<T> responseType);
}
