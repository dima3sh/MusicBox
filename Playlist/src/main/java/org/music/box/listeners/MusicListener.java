package org.music.box.listeners;

import org.mapstruct.factory.Mappers;
import org.music.box.documents.Song;
import org.music.box.dto.SongResponseDto;
import org.music.box.dto.SongSearchingDto;
import org.music.box.mapping.MusicMapper;
import org.music.box.repository.MusicRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MusicListener {

    private final MusicRepository musicRepository;

    public MusicListener(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @RabbitListener(queues = {"${rabbitmq.queue.name}"}, containerFactory = "rabbitListenerContainerFactory")
    public List<SongResponseDto> findAllSongs(SongSearchingDto search) {
        Page<Song> songs = musicRepository.findByTitleContainingOrSubtitleContaining(search.getSearch(), PageRequest.of(search.getPage(), search.getSize()));
        return Mappers.getMapper(MusicMapper.class).mapSong(songs.getContent());
    }
}
