package org.music.box.service;

import org.music.box.dto.PlaylistResponseDto;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDto> getAll();
}
