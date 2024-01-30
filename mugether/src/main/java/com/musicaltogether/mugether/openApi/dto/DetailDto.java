package com.musicaltogether.mugether.openApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class DetailDto {
    /**
     *  OPEN API 통해 가져온 데이터를 받는 DTO : 공연 상세
     */
    private String mt20id; // 공연ID
    private String prfnm; // 공연명
    private String prfpdfrom; // 공연시작일
    private String prfpdto; // 공연종료일
    private String fcltynm; // 공연시설명(공연장명)
    private String prfcast; // 공연출연진
    private String prfcrew; //공연제작진
    private String prfruntime; // 공연 런타임
    private String prfage; // 공연 관람 연령
    private String entrpsnm; // 기획사or제작사or주최or주관,
    private String pcseguidance; // 티켓가격
    private String poster; // 포스터 이미지 경로
    private String sty; // 줄거리
    private String genrenm; // 공연장르명
    private String openrun; // 오픈런
    private String prfstate; // 공연상태
    private List<ImgUrlsDto> styurls; // 소개이미지목록
    private String mt10id; // 공연시설ID
    private String dtguidance; // 공연시간

}
