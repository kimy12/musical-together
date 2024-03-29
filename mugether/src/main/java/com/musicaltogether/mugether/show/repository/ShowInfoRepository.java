package com.musicaltogether.mugether.show.repository;

import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.dto.ShowDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    /**
     * 공연 리스트
     * @param searchShowForm
     * @return
     */
    public List<ShowDto> findShowAllById(ShowDto searchShowForm) {
        String jpql = "select a.rnum, a.mt20id, a.regDt, a.area,a.poster, a.prfnm, a.prfpd, b.status, b.userId from Show a ";

        boolean isFirstCondition = true;

        // 북마크 on / off
        if(searchShowForm.isBookmark()) {
            jpql += "inner join a.showBookMarks b where b.userId = :userId and b.status=true ";
        } else {
            //jpql += "left join a.showBookMarks b where b.userId = :userId or b.userId is null ";
            jpql += "left join a.showBookMarks b on b.userId = :userId ";
            isFirstCondition = false;
        }

        // 공연명 검색
        if (!searchShowForm.getSearchKeyword().isEmpty()) {
            if (isFirstCondition) jpql += "and ";
            else jpql += "where ";
            jpql += "a.prfnm like :searchKeyword ";
        }


        jpql += "order by a.rnum"; // 기본 정렬

        TypedQuery<ShowDto> query = em.createQuery(jpql, ShowDto.class);

        query = query.setParameter("userId", searchShowForm.getUserId()); // 사용자 아이디
        if (!searchShowForm.getSearchKeyword().isEmpty()) {
            query = query.setParameter("searchKeyword", "%"+searchShowForm.getSearchKeyword()+"%");
        }

        return query.getResultList();
    }

    public List<ShowDto> findShowAllById(String userId){
        return em.createQuery("select a.rnum, a.mt20id, a.regDt, a.area,a.poster, a.prfnm, a.prfpd, " +
                        "b.status, b.userId " +
                        "from Show a " +
                        "left join a.showBookMarks b " +
                        "on b.userId = :userId " +
                        "order by a.rnum", ShowDto.class)
                .setParameter("userId", userId)
                .getResultList();
    }
}
