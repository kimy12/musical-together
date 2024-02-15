package com.musicaltogether.mugether.board.domain;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "board_info")
@Getter
public class BoardInfo {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id; // 게시판 아이디

    private String showId; // 공연 아이디

    private LocalDateTime regId; // 게시판 생성 날짜

    private String status; // 게시판 상태

    private String catgry; // 게시판 종류

    /**
     * 연관관계의 주인으로 잡는다.
     */
    @ManyToOne(fetch = FetchType.LAZY) // x to one 인 경우 default 가 EAGER 이다. LAZY 비꾸는거 중요함
    @JoinColumn(name = "show_id") // fk
    @Setter
    private Show show;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

//    ==========연관관계 메서드========   //

    public void setShow(Show show){
        this.show = show;
        show.getBoardInfos().add(this);
    }

    public void setBoard(Board board){
        this.board = board;
        board.setBoardInfo(this);
    }
}
