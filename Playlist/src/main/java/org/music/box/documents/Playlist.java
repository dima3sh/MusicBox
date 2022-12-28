package org.music.box.documents;

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

    public static class PlaylistItem {
        private Long songId;
        private Date addDateTime;
    }
}