package com.musicaltogether.mugether.user.api;

import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.dto.BookMarkDto;
import com.musicaltogether.mugether.user.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookMarkApiController {
    private final BookMarkService bookMarkService;

    /**
     * 북마크를 true or false 처리한다.
     * @param bookMarkDto
     *
     */
    @PostMapping("/bookMark")
    public ResponseEntity<BookMark> updateBookMark(@RequestBody BookMarkDto bookMarkDto) throws Exception{
        BookMark bookMark = bookMarkService.saveBookMark(bookMarkDto);

        return new ResponseEntity<> (bookMark, HttpStatus.CREATED);

    }

}
