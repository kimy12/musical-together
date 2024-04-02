package com.musicaltogether.mugether.openApi.config;

public class OpenApiConst {

    // URL 필수 값

    /**
     * 기본 URL : 박스오피스 조회 목록
     */
    public static final String URL_SHOW = "http://kopis.or.kr/openApi/restful/boxoffice";
    public static final String URL_PLACE = "http://kopis.or.kr/openApi/restful/prfplc"; // 요청 URL : 공연시설 목록
    public static final String URL_DETAIL = "http://kopis.or.kr/openApi/restful/pblprfr"; // 요청 URL : 공연 상세
    public static final String SERVICE_KEY = "?service=2dd15a4b568046bab37997ac27d5e074"; // 서비스 키



    // https://kopis.or.kr/openApi/restful/boxoffice?service=2dd15a4b568046bab37997ac27d5e074&ststype=month&date=20240124&catecode=GGGA

    // 공연장소 예시 url
    // http://kopis.or.kr/openApi/restful/prfplc?service=2dd15a4b568046bab37997ac27d5e074&cpage=1&rows=5


}
