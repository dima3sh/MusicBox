package org.music.box.external.controller.controller;

import org.music.box.external.controller.dto.SongResponseDto;
import org.music.box.external.controller.dto.SongSearchingDto;
import org.music.box.external.controller.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/music")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping("/songs/{search}")
    public ResponseEntity<List<SongResponseDto>> findSongs(@PathVariable("search") String search,
                                                           @RequestParam("page") Integer page,
                                                           @RequestParam("size") Integer size) {
        return new ResponseEntity<>(playlistService.findSongs(new SongSearchingDto(search, page, size)), HttpStatus.OK);
    }

    @GetMapping("/{songId}")
    public ResponseEntity<Boolean> findSongs(@PathVariable("songId") UUID songId) {
        //playlistService.findSongs("songId");
        return ResponseEntity.ok(true);
    }
}