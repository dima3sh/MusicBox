package org.music.box.service;

import org.music.box.dto.PlaylistResponseDto;
import org.music.box.dto.SongResponseDto;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDto> getAll();

    List<SongResponseDto> findAllSongs();
}
