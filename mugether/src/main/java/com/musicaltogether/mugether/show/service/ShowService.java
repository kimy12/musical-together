package com.musicaltogether.mugether.show.service;

import com.musicaltogether.mugether.openApi.dto.DetailDto;
import com.musicaltogether.mugether.openApi.service.OpenApiManager;
import com.musicaltogether.mugether.show.domain.Place;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.dto.ShowDto;
import com.musicaltogether.mugether.show.repository.ShowInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if(show!=null) {
            if (show.getPlace().getMt10id() == null){
                Place place = new Place();
                // 공연장소 id 저장 로직
                show = Show.builderForPlace(place).build();
            }
            return show; // showId가 존재하고 있었으면 리턴
        }
        DetailDto dto = openApiManager.fetchByDetail(id); // open api
        Show entity = Show.builderForD(dto).build();
        showInfoRepository.save(entity); // 저장
        return entity;
    }

    public List<ShowDto> findShowAllById(ShowDto searchShowForm) {return showInfoRepository.findShowAllById(searchShowForm); }

    /**
     * 박스오피스 모든 공연들을 가져온다. (미로그인 사용자)
     * @return
     */
    public List<Show> findAll(){
        return showInfoRepository.findAll();
    }

    /**
     * 로그인 한 사용자의 북마크 포함 모든 공연들을 가져온다.
     * @param
     * @return
     */
    public List<ShowDto> findShowAllById(String userId) {return showInfoRepository.findShowAllById(userId); }

    public Show findOne (String showId){
        return showInfoRepository.findOne(showId);
    }
}
