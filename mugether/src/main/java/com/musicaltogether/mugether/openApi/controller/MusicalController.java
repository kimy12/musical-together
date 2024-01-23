package com.musicaltogether.mugether.openApi.controller;

import com.musicaltogether.mugether.openApi.service.MusicalApiSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicalApi")
@RequiredArgsConstructor
public class MusicalController {

    private final MusicalApiSerive musicalApiSerive;
}
