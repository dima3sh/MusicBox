package org.music.box.external.controller.configuration.music.playlist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.music.box.external.controller.configuration.music.playlist.dto.SongResponseDto;
import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistServiceImpl.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final KafkaTemplate<Long, Object> template;
    private final ObjectMapper mapper;

    @Autowired
    public PlaylistServiceImpl(KafkaTemplate<Long, Object> template, ObjectMapper mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public Boolean addSong(UserSongRequestDto request) {
        template.send("playlist", request);
        return null;
    }

    @Override
    public List<SongResponseDto> findSongs() {
        LOGGER.info(String.format("Message sent -> %s", "asd"));
        Object response = (Object) rabbitTemplate.convertSendAndReceive(exchange, routingKey, "asd");
        System.out.println(response.toString());
        //return response;
        //rabbitTemplate.convertAndSend(exchange, routingKey, "aba");
        return null;
    }

//    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
//    public List<SongResponseDto> findAllSongs(String aba) {
//        LOGGER.info(String.format("Message sent -> %s", aba));
//        return null;
//    }

//    @Override
//    public List<SongResponseDto> findSongs() {
//        CompletableFuture<SendResult<Long, Object>> future = template.send("playlist", null);
//        try {
//            return (List<SongResponseDto>)future.get().getProducerRecord().value();
//        } catch (Exception e) {
//            return null;
//        }
//    }

    private <T> T getResult(String topic, Object data, Class<T> clazz) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Long, Object>> future = template.send(topic, data);
        return (T)future.get().getProducerRecord().value();
    }
}
