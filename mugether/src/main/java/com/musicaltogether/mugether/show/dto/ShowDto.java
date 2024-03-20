package com.musicaltogether.mugether.show.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ShowDto {

    private String mt20id; // 공연ID

    private String prfnm; // 공연이름

    private int rnum; // 순위

    private LocalDateTime regDt; // 생성 날짜 (db)

    private String area; // 공연 지역

    private String poster; // 포스터이미지경로

    private String prfpd; // 공연 기간

    private Boolean status; // 북마크 상태

    //(임시)
    private String userId; // 북마크한 user id (로그인한 id)

    private String bookmark; // 북마크 on or off : 북마크 표시한 리스트만 보기

    public ShowDto(Integer rnum, String mt20id, LocalDateTime regDt, String area, String poster, String prfnm, String prfpd, Boolean status, String userId) {
        this.rnum = rnum;
        this.mt20id = mt20id;
        this.regDt = regDt;
        this.area = area;
        this.poster = poster;
        this.prfnm = prfnm;
        this.prfpd = prfpd;
        this.status = status;
        this.userId = "testUserId2";
    }
}
