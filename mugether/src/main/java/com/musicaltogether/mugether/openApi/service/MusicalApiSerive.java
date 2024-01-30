package com.musicaltogether.mugether.openApi.service;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.dto.DetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class MusicalApiSerive {

    // 페이지 당 목록 수
    private final int DEFAULT_ROWS = 10;

    // 현재 페이지
    private final int DEFAULT_PAGE = 1;

    private final String GENRE_PLAY = "AAAA"; // 연극

    private final String GENRE_MUSICAL = "GGGA"; // 뮤지컬

    private final OpenApiManager openApiManager;

    /**
     * 박스오피스 순위 순 으로 리스트를 불러온다.
     *
     * @param ststype 날짜 타입 : 년.월.일
     * @param date 날짜
     * @return
     */
    public List<BoxofsDto> getBoxOfsList (String catgry, String ststype, String date){
        if("musical".equals(catgry)) return openApiManager.fetchByBoxOfs(ststype, date, GENRE_MUSICAL); // 뮤지컬
        return openApiManager.fetchByBoxOfs(ststype, date, GENRE_PLAY); // 연극
    }

    /**
     * 공연 아이디로 공연 상세를 불러온다.
     * @param showId 공연 아이디
     * @return
     */
    public DetailDto getDetailById (String showId){

        return openApiManager.fetchByDetail(showId);
    }

}