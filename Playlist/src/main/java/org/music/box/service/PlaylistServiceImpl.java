package org.music.box.service;

import org.music.box.dto.PlaylistResponseDTO;
import org.music.box.mapping.PlaylistMapper;
import org.music.box.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    @Override
    public List<PlaylistResponseDTO> getAll() {
        return playlistRepository
                .findAll()
                .stream()
                .map(PlaylistMapper.INSTANCE::playlistToPlaylistResponseDTO)
                .collect(Collectors.toList());
    }
}
