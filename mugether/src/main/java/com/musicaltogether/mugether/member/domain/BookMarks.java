package com.musicaltogether.mugether.member.domain;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_bookMarks")
@Getter
public class BookMarks {

    @Id @GeneratedValue
    @Column(name = "bookMark_id")
    private Long id;

    private String userId;

    private String status;

    /**
     * 연관관계의 주인으로 잡는다.
     */
    @ManyToOne(fetch = FetchType.LAZY) // x to one 인 경우 default 가 EAGER 이다. LAZY 비꾸는거 중요함
    @JoinColumn(name = "show_id") // fk
    @Setter
    private Show show;
}
