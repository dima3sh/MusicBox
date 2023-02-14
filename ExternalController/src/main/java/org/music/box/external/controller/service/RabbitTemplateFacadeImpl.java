package org.music.box.external.controller.service;

import org.music.box.external.controller.configuration.enums.RabbitMethod;
import org.music.box.external.controller.configuration.enums.RabbitType;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class RabbitTemplateFacadeImpl implements RabbitTemplateFacade{

    private final RabbitAdmin admin;
    private final RabbitTemplate rabbitTemplate;

    public RabbitTemplateFacadeImpl(RabbitAdmin admin, RabbitTemplate rabbitTemplate) {
        this.admin = admin;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public <T> T sendMessageAndReceive(final RabbitMethod method, RabbitType type, Object obj, ParameterizedTypeReference<T> responseType) {
        String queueName = method.getName() + "." + type.getName();
        if (admin.getQueueProperties(queueName) == null) {
            Queue queue = new Queue(queueName);
            DirectExchange exchange = new DirectExchange("exchange");
            Binding binding = BindingBuilder.bind(queue).to(exchange).with("routing_key");
            admin.declareQueue(queue);
            admin.declareBinding(binding);
        }
        return rabbitTemplate.convertSendAndReceiveAsType("exchange", "routing_key", obj, responseType);
    }
}
