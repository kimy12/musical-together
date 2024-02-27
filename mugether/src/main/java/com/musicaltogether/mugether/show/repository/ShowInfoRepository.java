package com.musicaltogether.mugether.show.repository;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShowInfoRepository{
    private final EntityManager em;

    public void save (Show show){
        em.persist(show);
    }

    public Show findOne(String showId){
        return em.find(Show.class, showId);
    }

    public List<Show> findAll() {
        return em.createQuery("select i from Show i", Show.class)
                .getResultList();
    }
}
