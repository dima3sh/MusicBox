package org.music.box.listeners;

import org.music.box.dto.UserSongRequestDto;
import org.music.box.service.PlaylistService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PlaylistListener {

    private final PlaylistService playlistService;

    public PlaylistListener(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @KafkaListener(topics="playlist", containerFactory = "singleFactory")
    public void orderListener(UserSongRequestDto requestDto){
        System.out.println("hello");//todo rewrite
    }
}
