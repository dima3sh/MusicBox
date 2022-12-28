package org.music.box.external.controller.configuration.music.playlist.service;

import org.music.box.external.controller.configuration.music.playlist.dto.UserSongRequestDto;

public interface PlaylistService {

    Boolean addSong(UserSongRequestDto request);
}
