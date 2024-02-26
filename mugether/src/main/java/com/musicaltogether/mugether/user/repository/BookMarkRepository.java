package com.musicaltogether.mugether.user.repository;

import com.musicaltogether.mugether.user.domain.BookMarks;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BookMarkRepository {

    private final EntityManager em;

    public void save(BookMarks bookMarks) {em.persist(bookMarks);}

    public BookMarks findOne(BookMarks bookMarks){return em.find(BookMarks.class, bookMarks);}
}
