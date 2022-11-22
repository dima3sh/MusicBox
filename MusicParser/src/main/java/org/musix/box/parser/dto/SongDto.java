package org.musix.box.parser.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SongDto {

    private Long key;
    private String subtitle;
    private String title;
    private List<ObjectNode> sections;
    private String alias;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate releasedate;
}
