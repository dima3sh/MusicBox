package org.music.box.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongSearchingDto {

    private String search;
    private Integer page;
    private Integer size;
}
