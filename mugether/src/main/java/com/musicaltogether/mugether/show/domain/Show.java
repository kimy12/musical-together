package com.musicaltogether.mugether.show.domain;

import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.dto.DetailDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
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

    /*@Column(name = "show_prd")
    private String prfpd; // 공연 기간*/

    @Column(name = "prd_from")
    private String prfpdfrom;

    @Column(name = "prd_to")
    private String prfpdto;

    @Column(name = "poster_path")
    private String poster; // 포스터이미지경로

    private String area; // 공연 지역

    private String cate; // 공연 장르명

    @Column(name = "show_cnt")
    private int prfdtcnt; // 공연 횟수

    @Column(name = "reg_dt")
    @CreatedDate
    private LocalDateTime regDt; // 생성 날짜 (db)

    @Column(name = "show_cast")
    private String prfcast; // 배우

    @Column(name = "show_rntime")
    private String prfruntime; // 러닝 타임

    private String prfage; // 연령

    public static ShowBuilder builder (BoxofsDto dto){
        return ShowBuilder()
                .mt20id(dto.getMt20id())
                .area(dto.getArea())
                .cate(dto.getCate())
                .prfnm(dto.getPrfnm())
                .poster(dto.getPoster())
                .prfdtcnt(dto.getPrfdtcnt())
                .rnum(dto.getRnum());
                //.prfpd(dto.getPrfpd());
    }

    public static ShowBuilder builderForD (DetailDto dto){
        return ShowBuilder()
                .mt20id(dto.getMt20id())
                .prfnm(dto.getPrfnm())
                .prfpdfrom(dto.getPrfpdfrom())
                .prfpdto(dto.getPrfpdto())
                .prfplcnm(dto.getFcltynm())
                .prfcast(dto.getPrfcast())
                .prfruntime(dto.getPrfruntime())
                .prfage(dto.getPrfage());
    }
}
