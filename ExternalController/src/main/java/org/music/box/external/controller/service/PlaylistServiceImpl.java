package org.music.box.external.controller.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.music.box.external.controller.configuration.enums.RabbitMethod;
import org.music.box.external.controller.configuration.enums.RabbitType;
import org.music.box.external.controller.dto.SongResponseDto;
import org.music.box.external.controller.dto.SongSearchingDto;
import org.music.box.external.controller.dto.UserSongRequestDto;
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

    private final RabbitTemplateFacadeImpl rabbitTemplateFacade;

    @Autowired
    public PlaylistServiceImpl(RabbitTemplateFacadeImpl rabbitTemplateFacade) {
        this.rabbitTemplateFacade = rabbitTemplateFacade;
    }

    @Override
    public Boolean addSong(UserSongRequestDto request) {
        //rabbitTemplate.send("playlist", request);
        return null;
    }

    @Override
    public List<SongResponseDto> findSongs(SongSearchingDto search) {
        LOGGER.info(String.format("Message sent -> %s", "asd"));
        return rabbitTemplateFacade.sendMessageAndReceive(RabbitMethod.GET, RabbitType.PLAYLIST, search, SONGS);
    }
}
