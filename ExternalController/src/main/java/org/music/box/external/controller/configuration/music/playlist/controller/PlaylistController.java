package org.music.box.external.controller.configuration.music.playlist.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/music")
public class PlaylistController {

    @GetMapping("/{songId}")
    public ResponseEntity<Boolean> addSong(@RequestParam UUID songId) {
        return ResponseEntity.ok(true);
    }
}
