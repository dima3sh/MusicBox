package org.music.box.service;

import org.music.box.dto.PlaylistResponseDTO;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDTO> getAll();
}
