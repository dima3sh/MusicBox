package org.music.box.repository;

import org.music.box.documents.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Song, Long> {

}
