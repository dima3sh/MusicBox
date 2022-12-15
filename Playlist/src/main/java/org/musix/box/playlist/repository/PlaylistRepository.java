package org.musix.box.playlist.repository;

import org.musix.box.playlist.documents.Playlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlaylistRepository extends MongoRepository<Playlist, UUID> {
}
