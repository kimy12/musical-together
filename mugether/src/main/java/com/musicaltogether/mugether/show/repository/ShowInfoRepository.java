package com.musicaltogether.mugether.show.repository;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShowInfoRepository{
    private final EntityManager em;

    public void save (Show show){
        em.persist(show);
    }
}
