package com.musicaltogether.mugether.show.controller;

import com.musicaltogether.mugether.show.dto.ShowDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShowPlaceController {

    @GetMapping("/placeList")
    public String getshowList (
            Model model) {

        return "boxOfs/main";
    }
}
