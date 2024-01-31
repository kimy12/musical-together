package com.musicaltogether.mugether.openApi.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Statement;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Getter
public class BoxofsDto {
        /**
         *  OPEN API 통해 가져온 데이터를 받는 DTO : 박스오피스 순
         */

        private String prfplcnm; // 공연장소

        private int seatcnt; // 좌석수

        private int rnum; // 순위

        private String mt20id; // 공연ID

        private String prfnm; // 공연명

        private String prfpd; // 공연 기간

        private String poster; // 포스터이미지경로

        private String area; // 공연 지역

        private String cate; // 공연 장르명

        private int prfdtcnt; // 공연 횟수
}
