package org.music.box.service;

import org.music.box.dto.PlaylistResponseDto;
import org.music.box.dto.SongResponseDto;
import org.music.box.dto.SongSearchingDto;
import org.music.box.dto.UserSongRequestDto;

import java.util.List;

public interface PlaylistService {
    List<PlaylistResponseDto> getAll();

    List<SongResponseDto> findAllSongs();

    List<SongResponseDto> findAllSongs(SongSearchingDto search);

    Boolean addSong(UserSongRequestDto request);


}
