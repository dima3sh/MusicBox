package org.music.box.external.controller.configuration.music.playlist.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.music.box.external.controller.configuration.music.playlist.dto.SongResponseDto;
import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PlaylistServiceImpl implements PlaylistService {

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
        CompletableFuture<SendResult<Long, Object>> future = template.send("playlist", null);
        try {
            return (List<SongResponseDto>)future.get().getProducerRecord().value();
        } catch (Exception e) {
            return null;
        }
    }

    private <T> T getResult(String topic, Object data, Class<T> clazz) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<Long, Object>> future = template.send(topic, data);
        return (T)future.get().getProducerRecord().value();
    }
}
