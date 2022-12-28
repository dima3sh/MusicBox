package org.music.box.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.music.box.documents.Playlist;
import org.music.box.dto.PlaylistResponseDTO;

@Mapper
public interface PlaylistMapper {
    PlaylistMapper INSTANCE = Mappers.getMapper(PlaylistMapper.class);

    PlaylistResponseDTO playlistToPlaylistResponseDTO(Playlist source);
}
