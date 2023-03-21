package org.music.box.external.controller.service;

import org.music.box.external.controller.configuration.enums.RabbitMethod;
import org.music.box.external.controller.configuration.enums.RabbitType;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class RabbitTemplateFacadeImpl implements RabbitTemplateFacade{

    private final String exchange;
    private final String routingKey;
    private final RabbitAdmin admin;
    private final RabbitTemplate rabbitTemplate;

    public RabbitTemplateFacadeImpl(RabbitAdmin admin,
                                    RabbitTemplate rabbitTemplate,
                                    @Value("${rabbitmq.routing.key}") String routingKey,
                                    @Value("${rabbitmq.exchange.name}") String exchange) {
        this.admin = admin;
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Override
    public <T> T sendMessageAndReceive(final RabbitMethod method, RabbitType type, Object obj, ParameterizedTypeReference<T> responseType) {
        String queueName = method.getName() + "." + type.getName();
        if (admin.getQueueProperties(queueName) == null) {
            Queue queue = new Queue(queueName);
            DirectExchange exchange = new DirectExchange(this.exchange);
            Binding binding = BindingBuilder.bind(queue).to(exchange).with(queueName);
            admin.declareQueue(queue);
            admin.declareBinding(binding);
        }
        String routingKey = queueName;
        return rabbitTemplate.convertSendAndReceiveAsType(this.exchange, routingKey, obj, responseType);
    }
}
