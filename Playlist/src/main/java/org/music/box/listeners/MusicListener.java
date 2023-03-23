package org.music.box.listeners;

import org.mapstruct.factory.Mappers;
import org.music.box.documents.Song;
import org.music.box.dto.SongRequestDto;
import org.music.box.dto.SongResponseDto;
import org.music.box.dto.SongSearchingDto;
import org.music.box.dto.UserSongRequestDto;
import org.music.box.mapping.MusicMapper;
import org.music.box.repository.MusicRepository;
import org.music.box.service.PlaylistService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class MusicListener {

    private final MusicRepository musicRepository;
    private final PlaylistService playlistService;

    public MusicListener(MusicRepository musicRepository, PlaylistService playlistService) {
        this.musicRepository = musicRepository;
        this.playlistService = playlistService;
    }

    @RabbitListener(queues = {"POST.SONG"}, containerFactory = "rabbitListenerContainerFactory")
    public Boolean addSong(UserSongRequestDto request) {
        return playlistService.addSong(request);
    }

    @RabbitListener(queues = {"GET.PLAYLIST"}, containerFactory = "rabbitListenerContainerFactory")
    public List<SongResponseDto> findAllSongs(SongSearchingDto search) {
        try {
            Page<Song> songs = musicRepository.findByTitleContainingOrSubtitleContaining(search.getSearch(), PageRequest.of(search.getPage(), search.getSize()));
            return Mappers.getMapper(MusicMapper.class).mapSong(songs.getContent());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @RabbitListener(queues = {"GET.USER_PLAYLIST"}, containerFactory = "rabbitListenerContainerFactory")
    public List<SongResponseDto> findUserSongs(UUID requestDto) {
        try {
            SongRequestDto requestDt2 = new SongRequestDto() {
            };
            //Page<Song> songs = musicRepository.findByTitleContainingOrSubtitleContaining();
            return null;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
