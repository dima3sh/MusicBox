package org.music.box.external.controller.configuration.music.playlist.controller;

import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;
import org.music.box.external.controller.configuration.music.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/music")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/{songId}")
    public ResponseEntity<Boolean> findSongs(@PathVariable("songId") UUID songId) {
        playlistService.findSongs();
        return ResponseEntity.ok(true);
    }
}
