package org.music.box.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.music.box.documents.Playlist;
import org.music.box.dto.PlaylistResponseDto;

@Mapper
public interface PlaylistMapper {

    PlaylistResponseDto playlistToPlaylistResponseDto(Playlist playlist);
}
