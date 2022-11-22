package org.musix.box.parser.repository;

import org.musix.box.parser.documents.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Song, String> {
}
