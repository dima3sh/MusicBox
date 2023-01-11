package org.music.box.external.controller.configuration.music.playlist.service;

import org.music.box.external.controller.configuration.music.playlist.dto.SongResponseDto;
import org.music.box.external.controller.configuration.music.playlist.dto.SongSearchingDto;
import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;

import java.util.List;

public interface PlaylistService {

    Boolean addSong(UserSongRequestDto request);

    List<SongResponseDto> findSongs(SongSearchingDto search);
}
