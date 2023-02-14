package org.music.box.external.controller.service;

import org.music.box.external.controller.dto.SongResponseDto;
import org.music.box.external.controller.dto.SongSearchingDto;
import org.music.box.external.controller.dto.UserSongRequestDto;

import java.util.List;

public interface PlaylistService {

    Boolean addSong(UserSongRequestDto request);

    List<SongResponseDto> findSongs(SongSearchingDto search);
}
