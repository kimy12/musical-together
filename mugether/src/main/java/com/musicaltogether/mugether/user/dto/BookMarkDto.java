package com.musicaltogether.mugether.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookMarkDto {

    private String showId;

    private String userId;

    private Boolean status;
}
