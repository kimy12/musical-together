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
@Getter
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
    private String prfpdfrom; // 공연 시작

    @Column(name = "prd_to")
    private String prfpdto; // 공연 종료

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

    @Column(name = "show_age")
    private String prfage; // 연령

    @Column(name = "ticket_price")
    private String pcseguidance; // 티켓 가격

    @Column(name = "state")
    private String prfstate; // 공연 상태

    @Column(name = "plc_code")
    private String mt10id; // 공연장소 코드

    /**
     * 박스오피스 리스트 더미데이터용 빌더
     * @param dto
     * @return
     */
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
                .prfage(dto.getPrfage())
                .pcseguidance(dto.getPcseguidance())
                .poster(dto.getPoster())
                .cate(dto.getGenrenm())
                .prfstate(dto.getPrfstate())
                .mt10id(dto.getMt10id());

    }
}
