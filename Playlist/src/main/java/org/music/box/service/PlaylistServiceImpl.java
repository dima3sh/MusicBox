package org.music.box.service;

import org.mapstruct.factory.Mappers;
import org.music.box.dto.PlaylistResponseDto;
import org.music.box.dto.SongResponseDto;
import org.music.box.mapping.PlaylistMapper;
import org.music.box.mapping.MusicMapper;
import org.music.box.repository.MusicRepository;
import org.music.box.repository.PlaylistRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MusicRepository musicRepository;

    @Autowired
    public PlaylistServiceImpl(PlaylistRepository playlistRepository,
                               MusicRepository musicRepository) {
        this.playlistRepository = playlistRepository;
        this.musicRepository = musicRepository;
    }

    @Override
    public List<PlaylistResponseDto> getAll() {
        return playlistRepository
                .findAll()
                .stream()
                .map(Mappers.getMapper(PlaylistMapper.class)::playlistToPlaylistResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SongResponseDto> findAllSongs() {
        return Mappers.getMapper(MusicMapper.class).mapSong(musicRepository.findAll());
    }


    @RabbitListener(queues = {"${rabbitmq.queue.name}"}, containerFactory = "rabbitListenerContainerFactory")
    public List<SongResponseDto> findAllSongs(SongResponseDto aba) {

        return Mappers.getMapper(MusicMapper.class).mapSong(musicRepository.findAll());
    }
}
