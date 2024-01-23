package com.musicaltogether.mugether.openApi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
