package org.music.box.external.controller.configuration.music.playlist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.music.box.external.controller.configuration.music.playlist.dto.SongResponseDto;
import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlaylistServiceImpl.class);
    private final ParameterizedTypeReference<List<SongResponseDto>> SONGS = new ParameterizedTypeReference<>() {};

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    @Autowired
    public PlaylistServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    @Override
    public Boolean addSong(UserSongRequestDto request) {
        //rabbitTemplate.send("playlist", request);
        return null;
    }

    @Override
    public List<SongResponseDto> findSongs(String search) {
        LOGGER.info(String.format("Message sent -> %s", "asd"));
        return rabbitTemplate.convertSendAndReceiveAsType(exchange, routingKey, search, SONGS);
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
}
