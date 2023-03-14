package org.music.box.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("playlist")
public class Playlist {
    @Id
    private UUID userId;
    private List<PlaylistItem> items;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlaylistItem {
        private Long songId;
        private Date addDate;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PlaylistItem that = (PlaylistItem) o;
            return Objects.equals(songId, that.songId);
        }

        @Override
        public int hashCode() {
            return songId.hashCode();
        }
    }
}