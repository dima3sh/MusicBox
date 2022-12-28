package org.music.box.documents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
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
    private List<JsonNode> sections;
    private String alias;
    private LocalDate releaseDate;
}

