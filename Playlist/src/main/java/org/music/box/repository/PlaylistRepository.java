package org.music.box.repository;

import org.music.box.documents.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlaylistRepository extends MongoRepository<Playlist, UUID> {
}
