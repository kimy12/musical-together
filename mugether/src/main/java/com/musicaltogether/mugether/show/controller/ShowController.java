package com.musicaltogether.mugether.show.controller;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.service.PlayApiService;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShowController {

    private final PlayApiService playApiService;
    private final ShowService showService;

    /**
     * 공연 정보 더미 데이터를 넣는다. (뮤지컬)
     * @param datetyp 날짜 타입
     * @param date 날짜
     */
    @GetMapping("/saveShowList/{datetyp}/{date}")
    public void getShowByApi (@PathVariable("datetyp") String datetyp,
                              @PathVariable("date") String date) {

        String catgry = "musical"; // 뮤지컬
        List<BoxofsDto> listForSave = playApiService.getBoxOfsList(catgry, datetyp, date);
        for (BoxofsDto dto : listForSave){
            Show entity = Show.builder(dto).build();
            showService.saveShowInfo(entity);
        }

    }

}
