package com.musicaltogether.mugether.show.controller;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.dto.ShowDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShowPlaceController {

    @GetMapping("/placeList")
    public String getshowList (
            Model model) {

        return "boxOfs/main";
    }

    /**
     * 공연 장소 정보 더미 데이터를 넣는다.
     *
     */
    @GetMapping("/savePlaceList")
    public String getPlaceByApi () {

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

//        String catgry = "musical"; // 뮤지컬
//        List<BoxofsDto> listForSave = playApiService.getBoxOfsList(catgry, "month", date);
//
//        for (BoxofsDto dto : listForSave){
//            Show entity = Show.builder(dto).build();
//            showService.saveShowInfo(entity);
//        }
        return "boxOfs/main";
    }
}
