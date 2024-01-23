package com.musicaltogether.mugether.openApi.service;

import com.musicaltogether.mugether.openApi.config.OpenApiConst;
import com.musicaltogether.mugether.openApi.dto.OpenApiDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OpenApiManager {

    //조회 메서드들
    /*public List<OpenApiDto> fetchByArea (int areaCode, String status, int numOfPage){
        String areaUrl = makeAreaUrl(areaCode,status, numOfPage);
        return fetch(areaUrl);
    }*/

    // URL 조립 메서드
    /**
     *
     * @return 공연 리스트 기본 URL
     */
    public String setBaseUrlForShow (){
        return OpenApiConst.URL_SHOW + OpenApiConst.SERVICE_KEY ;
    }

    /**
     *
     * @return 공연 장소 리스트 기본 URL
     */
    public String setBaseUrlForPlace (){
        return OpenApiConst.URL_PLACE + OpenApiConst.SERVICE_KEY ;
    }

    /*private String makeAreaUrl (int areaCode, String status, int numOfPage){
        return setBaseUrlForShow() +
    }*/
}
