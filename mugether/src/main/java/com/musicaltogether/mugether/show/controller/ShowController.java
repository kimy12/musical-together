package com.musicaltogether.mugether.show.controller;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.service.PlayApiService;
import com.musicaltogether.mugether.show.domain.Show;
import com.musicaltogether.mugether.show.dto.ShowDto;
import com.musicaltogether.mugether.show.service.ShowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShowController {

    private final PlayApiService playApiService;
    private final ShowService showService;

    /**
     * 박스오피스 메인 화면을 불러온다. (로그인 사용자들 용 : 기본 북마크 on 상태)
     * @param model
     * @return
     */
    @GetMapping("/showList")
    public String getshowList (
            Model model) {
        showService.findShowAllById("testUserId2"); // 전체 공연 리스트
        model.addAttribute("resultList", showService.findShowAllById("testUserId2"));
        model.addAttribute("showSearch", new ShowDto());
        return "boxOfs/main";
    }
    /**
     * 박스오피스 메인 화면을 불러온다. (로그인 사용자들 용) - 북마크 on / off
     * @param searchShowForm 검색조건
     * @param model
     * @return
     */
    //@GetMapping(value = {"/showList", "/showList/{bookmarkOn}"})
    @PostMapping("/showList")
    public String getshowList (
            @ModelAttribute("showSearch") ShowDto searchShowForm,
            Model model) {
        List<ShowDto> resultList = new ArrayList<>();
        boolean bookmarkOn = searchShowForm.isBookmark();
        if(bookmarkOn) resultList = showService.findBookmarkShowAllById("testUserId2"); // 북마크한 공연 리스트
        else resultList = showService.findShowAllById("testUserId2"); // 전체 공연 리스트
        model.addAttribute("resultList", resultList);

        model.addAttribute("showSearch", searchShowForm);
        return "boxOfs/main";
    }

    /**
     * 사용자가 북마크한 공연들을 가져온다.
     * @param bookmark 북마크 리스트 (on / off)
     * @param model
     * @return
     */
    @GetMapping("/myBookMarkList/{bookmark}")
    public String getMyBookMarkList (
            @PathVariable(name = "bookmark") String bookmark,
            Model model){
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
