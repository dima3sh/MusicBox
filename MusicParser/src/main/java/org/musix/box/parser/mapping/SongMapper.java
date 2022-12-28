package org.musix.box.parser.mapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.musix.box.parser.documents.Song;
import org.musix.box.parser.dto.SongDto;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SongMapper {

    @Mapping(target="id", source="key")
    @Mapping(target="releaseDate", source="releasedate")
    @Mapping(target="text", expression="java(extractText(songDto.getSections()))")
    Song mapObject(SongDto songDto);

    default List<String> extractText(List<ObjectNode> sections) {
        return sections.stream()
                .filter(i -> i.get("text") != null)
                .map(i -> Arrays.asList(convert(i.get("text").toString(), String[].class)))
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    private static <T> T convert(String string, Class<T> pojo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(string, pojo);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
