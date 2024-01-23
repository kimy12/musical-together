package com.musicaltogether.mugether.openApi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OpenApiDto {

    /**
     *  OPEN API 통해 가져온 데이터를 받는 DTO
     */

    private String mt20id; // 공연ID
    private String prfnm; // 공연명
    private String prfpdfrom; // 공연시작일
    private String prfpdto; // 공연종료일
    private String fcltynm; // 공연시설명(공연장명)
    private String poster; // 포스터이미지경로
    private Long area; // 공연지역
    private String genrenm; // 공연 장르명
    private String prfstate; // 공연상태
}
