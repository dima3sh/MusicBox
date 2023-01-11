package org.music.box.repository;

import org.music.box.documents.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MusicRepository extends MongoRepository<Song, Long> {

    @Query("{ \"$or\" : [{ \"title\" : { \"$regularExpression\" : { \"pattern\" : \".*?0.*\", \"options\" : \"\"}}}," +
            " { \"subtitle\" : { \"$regularExpression\" : { \"pattern\" : \".*?0.*\", \"options\" : \"\"}}}]}")
    Page<Song> findByTitleContainingOrSubtitleContaining(String substring, Pageable pageable);
}
