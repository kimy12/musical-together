package com.musicaltogether.mugether.board.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Board {

    @Column(name = "board_id")
    private Long id; //게시판 아이디

    private String title; // 글 제목

    private String content; // 글 내용

    @Column(name = "reg_dt")
    private LocalDateTime regDt; // 등록 일시

    @Column(name = "reg_id")
    private String regId; // 등록자

    @Column(name = "edit_id")
    private LocalDateTime editDt; // 수정 일시

    @Column(name = "del_Yn")
    private String delYn; // 삭제 유무

    @Column(name = "board_cnt")
    private Integer boardCnt = 0; // 조회수

    @Column(name = "like_cnt")
    private Integer likeCnt = 0; // 좋아요

    @OneToOne(mappedBy = "board", fetch = FetchType.LAZY)
    @Setter
    private BoardInfo boardInfo;
}
