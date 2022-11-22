package org.musix.box.parser.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.musix.box.parser.documents.Song;
import org.musix.box.parser.dto.SongDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SongMapper {

    @Mapping(target="id", source="key")
    @Mapping(target="releaseDate", source="releasedate")
    Song mapObject(SongDto song);
}
