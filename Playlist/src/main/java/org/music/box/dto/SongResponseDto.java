package org.music.box.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SongResponseDto implements Serializable {

    private Long id;
    private String subtitle;
    private String title;
}
