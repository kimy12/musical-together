package com.musicaltogether.mugether.openApi.service;

import com.musicaltogether.mugether.openApi.config.OpenApiConst;
import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.dto.BoxofsListDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenApiManager {

    //조회 메서드
    public List<BoxofsDto> fetchByArea (String ststype, String date, String catecode){
        String areaUrl = makeAreaUrl(ststype, date, catecode);
        return fetch(areaUrl);
    }

    // URL 조립 메서드
    /**
     *
     * @return 공연 리스트 기본 URL
     */
    public String setBaseUrlForShow () {

        return OpenApiConst.URL_SHOW + OpenApiConst.SERVICE_KEY;
    }

    /**
     *
     * @return 공연 장소 리스트 기본 URL
     */
    public String setBaseUrlForPlace (){
        return OpenApiConst.URL_PLACE + OpenApiConst.SERVICE_KEY ;
    }

    /**
     *
     * @param ststype 날짜 타입 : month(월별), week(주별), day(일별)
     * @param date 기준 연도
     * @param catecode 카테 고리 : AAAA(연극), GGGA(뮤지컬)
     * @return 박스 오피스 순 목록 URL
     */
    private String makeAreaUrl (String ststype, String date, String catecode) {

        return setBaseUrlForShow() + "&ststype=" + ststype + "&date=" + date + "&catecode=" + catecode;
    }

    public List<BoxofsDto> fetch (String url) {

        RestTemplate restTemplate = new RestTemplate();

        BoxofsListDto result = restTemplate.getForObject(url, BoxofsListDto.class);

        List<BoxofsDto> resultList = result.getBoxofsDtoInfo();

        return resultList;
    }
}
