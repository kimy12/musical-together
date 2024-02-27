package com.musicaltogether.mugether.user.service;

import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.repository.ShowInfoRepository;
import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BookMarkService {
    private final BookMarkRepository bookMarkRepository;
    private final ShowInfoRepository showInfoRepository;

    @Transactional
    public void saveBookMark(BookMark bookMark) {
        BookMark findBookMark = bookMarkRepository.findOne(bookMark);
        if(findBookMark != null){
            // show id
            String showId = bookMark.getShow().getMt20id();
            Show show = showInfoRepository.findOne(showId);
            findBookMark.updateUnBookMark(show);
            return;
        }
        bookMarkRepository.save(bookMark);
    }
}
