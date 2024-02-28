package com.musicaltogether.mugether.user.repository;

import com.musicaltogether.mugether.user.domain.BookMark;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookMarkRepository {

    private final EntityManager em;

    public void save(BookMark bookMark) {em.persist(bookMark);}

    public BookMark findOne(String showId, String userId){
        return em.createQuery("select b from show_book_marks b where b.show_id = :showId and b.user_id = :userId", BookMark.class)
                .setParameter("showId", showId)
                .setParameter("userId", userId)
                .getSingleResult();
    }
}
