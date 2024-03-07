package com.musicaltogether.mugether.show.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShowDto {

    private String showId; // 공연ID

    private String showNm; // 공연이름

    private int rnum; // 순위

    private LocalDateTime regDt; // 생성 날짜 (db)

    private String area; // 공연 지역

    private String poster; // 포스터이미지경로

    private String prfpd; // 공연 기간

    private Boolean status; // 북마크 상태

    private String userId; // 북마크한 user id (로그인한 id)
}
