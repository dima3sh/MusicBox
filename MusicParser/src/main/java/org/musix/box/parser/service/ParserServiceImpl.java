package org.musix.box.parser.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.musix.box.parser.dto.SongDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ParserServiceImpl implements ParserService {

    private final WebClient webClient;

    public ParserServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Scheduled(fixedDelay = 1L)
    public void parseSongScheduled() {
        SongDto nd = findSong(507755527L);
        System.out.println(nd);
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
