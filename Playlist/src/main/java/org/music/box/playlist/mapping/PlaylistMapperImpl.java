package org.music.box.playlist.mapping;

import org.music.box.playlist.documents.Playlist;
import org.music.box.playlist.dto.PlaylistResponseDTO;

public class PlaylistMapperImpl implements PlaylistMapper {
    @Override
    public PlaylistResponseDTO playlistToPlaylistResponseDTO(Playlist playlist) {
        if (playlist == null) {
            return null;
        }
        PlaylistResponseDTO playlistResponseDTO = new PlaylistResponseDTO();
        playlistResponseDTO.setUserId(playlist.getUserId());
        return playlistResponseDTO;
    }
}
