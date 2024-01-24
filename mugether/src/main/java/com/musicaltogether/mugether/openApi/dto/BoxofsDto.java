package com.musicaltogether.mugether.openApi.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "boxofs")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter @Setter
public class BoxofsDto {

    /**
     *  OPEN API 통해 가져온 데이터를 받는 DTO : 박스오피스 순
     */

    @XmlElement(name = "prfplcnm")
    private String prfplcnm; // 공연장소

    @XmlElement(name = "seatcnt")
    private String seatcnt; // 좌석수

    @XmlElement(name = "rnum")
    private String rnum; // 순위

    @XmlElement(name = "mt20id")
    private String mt20id; // 공연ID

    @XmlElement(name = "prfnm")
    private String prfnm; // 공연명

    @XmlElement(name = "prfpd")
    private String prfpd; // 공연 기간

    @XmlElement(name = "poster")
    private String poster; // 포스터이미지경로

    @XmlElement(name = "area")
    private String area; // 공연 지역

    @XmlElement(name = "cate")
    private String cate; // 공연 장르명

    @XmlElement(name = "prfdtcnt")
    private String prfdtcnt; // 공연 횟수
}
