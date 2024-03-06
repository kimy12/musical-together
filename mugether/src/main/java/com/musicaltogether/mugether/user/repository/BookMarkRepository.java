package com.musicaltogether.mugether.user.repository;

import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.dto.BookMarkDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookMarkRepository {

    private final EntityManager em;

    public void save(BookMark bookMark) {em.persist(bookMark);}

    public Optional<BookMark> findBookMarks (BookMarkDto bookMarkDto){
        List<BookMark> bookMarks = em.createQuery("select b from show_bookmarks b where b.show.mt20id = :showId and b.userId = :userId", BookMark.class)
                .setParameter("showId", bookMarkDto.getShowId())
                .setParameter("userId", bookMarkDto.getUserId())
                .getResultList();

        return bookMarks.stream().findAny();
    }

//    public BookMark findOne(BookMarkDto bookMarkDto){
//        return em.createQuery("select b from show_bookmarks b where b.show.mt20id = :showId and b.userId = :userId", BookMark.class)
//                .setParameter("showId", bookMarkDto.getUserId())
//                .setParameter("userId", bookMarkDto.getShowId())
//                .getSingleResult();
//    }
}
