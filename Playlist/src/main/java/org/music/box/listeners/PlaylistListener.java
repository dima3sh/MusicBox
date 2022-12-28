package org.music.box.listeners;

import org.music.box.dto.SongResponseDto;
import org.music.box.dto.UserSongRequestDto;
import org.music.box.service.PlaylistService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlaylistListener {

    private final PlaylistService playlistService;

    public PlaylistListener(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @KafkaListener(topics="playlist", containerFactory = "singleFactory")
    public List<SongResponseDto> orderListener(UserSongRequestDto requestDto){
        return playlistService.findAllSongs();
    }
}
