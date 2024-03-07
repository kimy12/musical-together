package com.musicaltogether.mugether.show.repository;

import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.dto.ShowDto;
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

    public List<Show> findShowAllById(ShowDto showDto){
        return em.createQuery("select a.rnum, a.mt20id, a.regDt, a.area,a.poster, a.prfnm, a.prfpd, " +
                        "b.status, b.userId " +
                        "from show a " +
                        "left join fetch a.showBookMarks b" +
                        "where a.showBookMarks.userId = :userId or a.showBookMarks.userId is null " +
                        "order by a.rnum", Show.class)
                .setParameter("userId", showDto.getUserId())
                .getResultList();
    }
}
