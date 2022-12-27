package org.music.box.playlist.repository;

import org.music.box.playlist.documents.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlaylistRepository extends MongoRepository<Playlist, UUID> {
}
