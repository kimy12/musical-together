package com.musicaltogether.mugether.show.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "show_likes")
@Getter
public class Likes {

    @Id @GeneratedValue
    @Column(name = "likes_id")
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
