package com.musicaltogether.mugether.show.controller;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.service.PlayApiService;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShowController {

    private final PlayApiService playApiService;
    private final ShowService showService;

    @GetMapping("/showList")
    public String getshowList (Model model) {
        //model.addAttribute("resultList", showService.findAll());
        //List<ShowDto> resultList = showService.findShowAllById("testUserId2");
        model.addAttribute("resultList", showService.findShowAllById("testUserId2"));
        return "boxOfs/main";
    }

    /**
     * 공연 정보 더미 데이터를 넣는다. (뮤지컬)
     *
     */
    @GetMapping("/saveShowList")
    public String getShowByApi () {

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        String catgry = "musical"; // 뮤지컬
        List<BoxofsDto> listForSave = playApiService.getBoxOfsList(catgry, "month", date);

        for (BoxofsDto dto : listForSave){
            Show entity = Show.builder(dto).build();
            showService.saveShowInfo(entity);
        }
        return "boxOfs/main";
    }

    /**
     * 연극 or 뮤지컬 정보를 저장 및 가져온다.
     * @param showId showId
     * @param model
     * @return
     */
    @GetMapping("/boxofs/{showId}/show")
    public String getDetailbyApi (@PathVariable(name = "showId") String showId, Model model){

        Show show = showService.saveShowInfo(showId);
        model.addAttribute("showInfo", show);
        return "boxOfs/show-details";
    }

}
