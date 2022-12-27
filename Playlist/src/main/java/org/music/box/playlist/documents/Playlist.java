package org.music.box.playlist.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Document("playlist")
public class Playlist {
    @Id
    private UUID userId;
    private List<PlaylistItem> items;

    public UUID getUserId() {
        return userId;
    }

    public List<PlaylistItem> getItems() {
        return items;
    }

    public void setUserId(UUID id) {
        this.userId = id;
    }

    public void setItems(List<PlaylistItem> items) {
        this.items = items;
    }

    public static class PlaylistItem {
        private Long songId;
        private Date addDateTime;

        public PlaylistItem(Long songId, Date addDateTime) {
            this.songId = songId;
            this.addDateTime = addDateTime;
        }
    }
}