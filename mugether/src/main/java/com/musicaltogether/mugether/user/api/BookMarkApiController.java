package com.musicaltogether.mugether.user.api;

import com.musicaltogether.mugether.user.domain.BookMark;
import com.musicaltogether.mugether.user.service.BookMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookMarkApiController {
    private final BookMarkService bookMarkService;

    /**
     * 북마크를 true or false 처리한다.
     * @param showId
     * @param userId
     */
    @PostMapping("/bookMark")
    public void updateBookMark(@RequestParam("showId") String showId,
                               @RequestParam("userId") String userId){
        bookMarkService.saveBookMark(showId, userId);
    }

}
