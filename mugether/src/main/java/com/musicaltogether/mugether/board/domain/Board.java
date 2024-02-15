package com.musicaltogether.mugether.board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Board {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id; //게시판 아이디

    private String title; // 글 제목

    private String content; // 글 내용

    private LocalDateTime regDt; // 등록 일시

    private String regId; // 등록자

    private LocalDateTime editDt; // 수정 일시

    private String delYn; // 삭제 유무

    private Integer boardCnt = 0; // 조회수

    private Integer likeCnt = 0; // 좋아요

//    @OneToOne(mappedBy = "board", fetch = FetchType.LAZY)
//    @Setter
//    private BoardInfo boardInfo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "boardInfo_id")
    private BoardInfo boardInfo;

    //    ==========연관관계 메서드========   //

    public void setBoardInfo (BoardInfo boardInfo){
        this.boardInfo = boardInfo;
        boardInfo.setBoard(this);
    }
}
