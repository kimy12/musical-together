package com.musicaltogether.mugether.show.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

//@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Builder(builderMethodName = "PlaceBuilder")
@Getter
public class Place {

    /*@Column(name = "plc_id")
    private String mt10id;*/

    @Column(name = "plc_nm")
    private String fcltynm; // 공연 시설명

    @Column(name = "open_dt")
    private String opende; // 개관연도

    private String fcltychartr; // 시설특성

    private String seatchartr; // 객석 수

    private String telno; // 전화번호

    private String relateurl; // 홈페이지

    private String adres; // 주소

    private String la; // 위도

    private String lo; // 경도

    private String restaurant_yn; // 식당 유무

    private String cafe_yn; // 카페 유무

    private String store_yn; // 편의점 유무

    private String nolibang_yn; // 놀이방 유무

    private String suyu_yn; // 수유실 유무

    private String parkbarrier_yn; // 장애시설-주차장 유무

    private String restbarrier_yn; // 장애시설-화장실 유무

    private String runwbarrier_yn; // 장애시설-엘리베이터 유무
}
