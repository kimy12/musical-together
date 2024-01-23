package com.musicaltogether.mugether.openApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BoxofsDto {

    /**
     *  OPEN API 통해 가져온 데이터를 받는 DTO : 박스오피스 순
     */

    private String prfplcnm; // 공연장소
    private String seatcnt; // 좌석수
    private String rnum; // 순위
    private String mt20id; // 공연ID
    private String prfnm; // 공연명
    private String prfpd; // 공연 기간
    private String poster; // 포스터이미지경로
    private String area; // 공연 지역
    private String cate; // 공연 장르명
    private String prfdtcnt; // 공연 횟수
}
