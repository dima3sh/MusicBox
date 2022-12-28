package org.music.box.external.controller.configuration.music.playlist.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSongRequestDto {

    private String songId;
    private String userId;
}
