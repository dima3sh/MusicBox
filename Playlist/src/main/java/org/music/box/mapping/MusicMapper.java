package org.music.box.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.music.box.documents.Song;
import org.music.box.dto.SongResponseDto;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MusicMapper {

    SongResponseDto mapSong (Song song);

    List<SongResponseDto> mapSong (List<Song> song);
}
