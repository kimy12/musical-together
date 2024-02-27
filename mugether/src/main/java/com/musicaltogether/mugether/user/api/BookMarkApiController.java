package com.musicaltogether.mugether.user.api;

import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookMarkApiController {
    private final BookMarkService bookMarkService;

    @PostMapping("/bookMark")
    public void updateBookMark(@RequestBody BookMark bookMark){
        bookMarkService.saveBookMark(bookMark);
    }

}
