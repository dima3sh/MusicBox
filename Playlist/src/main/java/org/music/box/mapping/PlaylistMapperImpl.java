package org.music.box.mapping;

import org.music.box.documents.Playlist;
import org.music.box.dto.PlaylistResponseDTO;

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
