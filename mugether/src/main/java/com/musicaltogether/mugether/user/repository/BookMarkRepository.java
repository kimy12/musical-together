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

    public BookMark findOne(BookMark bookMark){return em.find(BookMark.class, bookMark);}
}
