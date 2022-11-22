package org.musix.box.parser.service;

import org.mapstruct.factory.Mappers;
import org.musix.box.parser.documents.Song;
import org.musix.box.parser.dto.SongDto;
import org.musix.box.parser.mapping.SongMapper;
import org.musix.box.parser.repository.MusicRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ParserServiceImpl implements ParserService {

    private final WebClient webClient;
    private final MusicRepository musicRepository;
    private static long num = 507755527L;

    public ParserServiceImpl(WebClient webClient,
                             MusicRepository musicRepository) {
        this.webClient = webClient;
        this.musicRepository = musicRepository;
    }

    @Scheduled(fixedDelay = 1L)
    public void parseSongScheduled() {
        SongDto nd = findSong(num);
        if (nd != null) {
            Song song = Mappers.getMapper(SongMapper.class).mapObject(nd);
            System.out.println(nd);
            musicRepository.save(song);
        }
        num++;
    }

    private SongDto findSong(Long songId) {
        return webClient
                .get()
                .uri(String.join("", "/discovery/v5/ru/BY/web/-/track/" + songId + "?shazamapiversion=v3&video=v3"))
                .retrieve()
                .bodyToMono(SongDto.class)
                .block();
    }
}
