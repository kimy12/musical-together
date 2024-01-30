package com.musicaltogether.mugether.openApi.controller;

import com.musicaltogether.mugether.openApi.service.MusicalApiSerive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BoxofsController {

    private final MusicalApiSerive musicalApiSerive;

    @RequestMapping("/")
    public String home(){
        log.info("home controller");
        return "boxOfs/main";
    }

    /**
     *
     * @param catgry 카테고리 (뮤지컬, 연극)
     * @param datetyp 연도기준 (년,월,일)
     * @param date 날짜 기준
     * @param model
     * @return
     */
    @GetMapping("/boxofs/{catgry}/{datetyp}/{date}")
    public String findAllBoxofs (@PathVariable("catgry") String catgry,
                                 @PathVariable("datetyp") String datetyp,
                                 @PathVariable("date") String date, Model model){

        model.addAttribute("resultList", musicalApiSerive.getBoxOfsList(catgry, datetyp, date));

        return "boxOfs/main";
    }
}