package com.musicaltogether.mugether.show.domain;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(builderMethodName = "ShowBuilder")
public class Show {

    @Id
    @Column(name = "show_id")
    private String mt20id; // 공연ID

    @Column(name = "plc_nm")
    private String prfplcnm; // 공연장소

    @Column(name = "seat_cnt")
    private int seatcnt; // 좌석수

    private int rnum; // 순위

    @Column(name = "show_nm")
    private String prfnm; // 공연명

    @Column(name = "show_prd")
    private String prfpd; // 공연 기간

    @Column(name = "poster_path")
    private String poster; // 포스터이미지경로

    private String area; // 공연 지역

    private String cate; // 공연 장르명

    @Column(name = "show_cnt")
    private int prfdtcnt; // 공연 횟수

    @Column(name = "reg_dt")
    @Temporal(TemporalType.DATE)
    private Date regDt = new Date();

    public static ShowBuilder builder (BoxofsDto dto){
        return ShowBuilder()
                .mt20id(dto.getMt20id())
                .area(dto.getArea())
                .cate(dto.getCate())
                .prfnm(dto.getPrfnm())
                .poster(dto.getPoster())
                .prfdtcnt(dto.getPrfdtcnt())
                .rnum(dto.getRnum())
                .prfpd(dto.getPrfpd());
    }
}
