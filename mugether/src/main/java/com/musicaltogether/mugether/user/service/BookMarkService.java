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

    /**
     * 북마크를 최초 설정하거나 취소합니다.
     * @param showId, userId
     */
    @Transactional
    public void saveBookMark(String showId, String userId) {
        BookMark findBookMark = bookMarkRepository.findOne(showId, userId);
        Show show = showInfoRepository.findOne(showId);
        if(findBookMark != null){
            if (findBookMark.getStatus()) findBookMark.updateUnBookMark(show); // 북마크 off
            else findBookMark.updateBookMark(show); // 북마크 on
        } else {
            BookMark bookMark = BookMark.createBookMark(show); // 북마크 생성 (on)
            bookMarkRepository.save(bookMark);
        }

    }
}
