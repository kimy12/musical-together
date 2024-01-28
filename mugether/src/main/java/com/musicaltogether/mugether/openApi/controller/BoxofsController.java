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

    @GetMapping("/musical/{datetyp}/{date}")
    public String findAllBoxofs (@PathVariable("datetyp") String datetyp, @PathVariable("date") String date, Model model){

        model.addAttribute("resultList", musicalApiSerive.getBoxOfsList(datetyp, date));

        return "boxOfs/main";
    }
}