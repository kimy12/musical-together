package com.musicaltogether.mugether.openApi.service;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.dto.BoxofsListDto;
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
     * 박스오피스 순위 순 으로 뮤지컬리스트를 불러온다.
     *
     * @param ststype 날짜 타입 : 년.월.일
     * @param date 날짜
     * @return
     */
    public String getBoxOfsList (String ststype, String date){

        return openApiManager.fetchByArea(ststype, date, GENRE_MUSICAL);
    }
}