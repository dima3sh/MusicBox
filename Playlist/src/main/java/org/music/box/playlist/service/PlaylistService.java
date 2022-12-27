package org.music.box.playlist.service;

import org.music.box.playlist.dto.PlaylistResponseDTO;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDTO> getAll();
}
