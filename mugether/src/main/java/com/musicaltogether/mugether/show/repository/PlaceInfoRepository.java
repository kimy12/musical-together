package com.musicaltogether.mugether.show.repository;

import com.musicaltogether.mugether.show.domain.Place;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlaceInfoRepository {

    private final EntityManager em;

    /**
     * 공연 장소 정보를 가져 온다.
     * @param placeId 장소 ID
     * @return 장소 정보
     */
    public Place findOne(String placeId){
        return em.find(Place.class, placeId);
    }
}
