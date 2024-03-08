package com.musicaltogether.mugether.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookMarkDto {

    private String showId;

    private String userId;

    private Boolean status;
}
