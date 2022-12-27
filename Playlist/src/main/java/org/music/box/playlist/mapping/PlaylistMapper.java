package org.music.box.playlist.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.music.box.playlist.documents.Playlist;
import org.music.box.playlist.dto.PlaylistResponseDTO;

@Mapper
public interface PlaylistMapper {
    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    PlaylistResponseDTO playlistToPlaylistResponseDTO(Playlist source);
}
