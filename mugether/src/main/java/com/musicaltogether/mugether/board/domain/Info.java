package com.musicaltogether.mugether.board.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Info {

    private Long id; // 게시판 아이디

    @Column(name = "show_id")
    private String showId; // 공연 아이디

    @Column(name = "reg_id")
    private LocalDateTime regId; // 게시판 생성 날짜

    private String status; // 게시판 상태

    private String catgry; // 게시판 종류

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "")
    private Board board;
}
