package com.musicaltogether.mugether.user.service;

import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.repository.ShowInfoRepository;
import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.dto.BookMarkDto;
import com.musicaltogether.mugether.user.repository.BookMarkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class BookMarkService {
    private final BookMarkRepository bookMarkRepository;
    private final ShowInfoRepository showInfoRepository;

    /**
     * 북마크를 최초 설정하거나 취소합니다.
     * @param bookMarkDto
     */
    @Transactional
    public BookMark saveBookMark(BookMarkDto bookMarkDto) throws Exception{
        //Optional<BookMark> findBookMark = bookMarkRepository.findBookMarks(bookMarkDto);
        BookMark findBookMark = bookMarkRepository
                .findBookMarks(bookMarkDto).orElseGet(BookMark::new);

        String userId = bookMarkDto.getUserId(); // userId (임시)

        Show show = showInfoRepository.findOne(bookMarkDto.getShowId());
        if(!Objects.isNull(findBookMark.getShow())){
            if (findBookMark.getStatus()) findBookMark.updateUnBookMark(show); // 북마크 off
            else findBookMark.updateBookMark(show); // 북마크 on
        } else {
            findBookMark = BookMark.createBookMark(show, userId); // 북마크 생성 (on)
            bookMarkRepository.save(findBookMark);
        }

        return findBookMark;
    }
}
