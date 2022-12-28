package org.music.box.external.controller.configuration.music.playlist.service;

import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final KafkaTemplate<Long, Object> template;

    @Autowired
    public PlaylistServiceImpl(KafkaTemplate<Long, Object> template) {
        this.template = template;
    }

    @Override
    public Boolean addSong(UserSongRequestDto request) {
        template.send("playlist", request);
        return null;
    }
}
