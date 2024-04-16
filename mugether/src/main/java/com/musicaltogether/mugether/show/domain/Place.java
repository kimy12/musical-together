package com.musicaltogether.mugether.show.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Builder(builderMethodName = "PlaceBuilder")
@Getter
public class Place {

    @Id
    @Column(name = "plc_id")
    private String mt10id;

    @Column(name = "plc_nm")
    private String fcltynm; // 공연 시설명

    @Column(name = "open_dt")
    private String opende; // 개관연도

    private String fcltyChartr; // 시설특성

    @Column(name = "seat_cnt")
    private String seatchartr; // 객석 수

    private String telNo; // 전화번호

    private String relateUrl; // 홈페이지

    private String adres; // 주소

    private String la; // 위도

    private String lo; // 경도

    @Column(name = "restaurant_yn")
    private String restaurant; // 식당 유무

    @Column(name = "cafe_yn")
    private String cafe; // 카페 유무

    @Column(name = "store_yn")
    private String store; // 편의점 유무

    @Column(name = "nolibang_yn")
    private String nolibang; // 놀이방 유무

    @Column(name = "suyu_yn")
    private String suyu; // 수유실 유무

    @Column(name = "parkbarrier_yn")
    private String parkbarrier; // 장애시설-주차장 유무

    @Column(name = "restbarrier_yn")
    private String restbarrier; // 장애시설-화장실 유무

    @Column(name = "runwbarrier_yn")
    private String runwbarrier; // 장애시설-엘리베이터 유무

    @Column(name = "elevbarrier_yn")
    private String elevbarrier; // 장애시설-엘리베이터

    @Column(name = "parkinglot_yn")
    private String parkinglot; // 주차시설

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt; // 생성 날짜 (db)

    @OneToMany(mappedBy = "place") @Setter
    private List<Show> shows = new ArrayList<>();
}
