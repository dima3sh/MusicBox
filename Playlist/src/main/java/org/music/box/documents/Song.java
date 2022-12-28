package org.music.box.documents;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document("music")
@NoArgsConstructor
public class Song {

    @Id
    private Long id;
    private String subtitle;
    private String title;
    private List<String> text;
    private String alias;
    private LocalDate releaseDate;
}

