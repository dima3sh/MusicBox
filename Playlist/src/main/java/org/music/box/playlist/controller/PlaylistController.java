package org.music.box.playlist.controller;

import org.music.box.playlist.dto.PlaylistResponseDTO;
import org.music.box.playlist.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/music")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping("/musics")
    public ResponseEntity<List<PlaylistResponseDTO>> getAll() {
        return new ResponseEntity<>(playlistService.getAll(), HttpStatus.OK);
    }
}
