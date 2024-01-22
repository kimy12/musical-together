package com.musicaltogether.mugether.api.controller;

import com.musicaltogether.mugether.api.service.MusicalApiSerive;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicalApi")
@RequiredArgsConstructor
public class MusicalController {

    private final MusicalApiSerive musicalApiSerive;
}
