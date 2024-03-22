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

    public List<ShowDto> findShowAllById(String userId){
        return em.createQuery("select a.rnum, a.mt20id, a.regDt, a.area,a.poster, a.prfnm, a.prfpd, " +
                        "b.status, b.userId " +
                        "from Show a " +
                        "left join a.showBookMarks b " +
                        "where b.userId = :userId or b.userId is null " +
                        "order by a.rnum", ShowDto.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public List<ShowDto> findBookmarkShowAllById (String userId) {
        return em.createQuery("select a.rnum, a.mt20id, a.regDt, a.area,a.poster, a.prfnm, a.prfpd, " +
                        "b.status, b.userId " +
                        "from Show a " +
                        "inner join a.showBookMarks b " +
                        "where b.userId = :userId and b.status=true " +
                        "order by a.rnum", ShowDto.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
