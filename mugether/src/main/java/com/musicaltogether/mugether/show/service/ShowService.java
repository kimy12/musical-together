package com.musicaltogether.mugether.show.service;

import com.musicaltogether.mugether.openApi.dto.DetailDto;
import com.musicaltogether.mugether.openApi.service.OpenApiManager;
import com.musicaltogether.mugether.show.controller.ShowForm;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.repository.ShowInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class ShowService {
    private final ShowInfoRepository showInfoRepository;
    private final OpenApiManager openApiManager;

    @Transactional
    public void saveShowInfo(Show show){
        showInfoRepository.save(show);
    }

    /**
     * 뮤지컬 or 연극 정보를 저장한다.
     * @param id : 공연 pk
     * @return
     */
    @Transactional
    public Show saveShowInfo(String id){
        Show show = showInfoRepository.findOne(id);
        if(show!=null) return show; // showId가 존재하고 있었으면 리턴
        DetailDto dto = openApiManager.fetchByDetail(id); // open api
        Show entity = Show.builderForD(dto).build();
        showInfoRepository.save(entity); // 저장
        return entity;
    }
    public Show findOne (String showId){
        return showInfoRepository.findOne(showId);
    }
}
