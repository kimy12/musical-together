package com.musicaltogether.mugether.openApi.service;

import com.musicaltogether.mugether.openApi.config.OpenApiConst;
import com.musicaltogether.mugether.openApi.dto.BoxofsDto;
import com.musicaltogether.mugether.openApi.dto.DetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
@Slf4j
public class OpenApiManager {

    //조회 메서드
    public List<BoxofsDto> fetchByBoxOfs (String ststype, String date, String catecode){
        String boxofsUrl = makeBasicUrl(ststype, date, catecode);
        return fetch(boxofsUrl);
    }

    public DetailDto fetchByDetail (String showId){
        String detailUrl = makeDetailUrl(showId);
        return fetchD(detailUrl);
    }

    // URL 조립 메서드
    /**
     *
     * @return 공연 리스트 기본 URL
     */
    public String setBaseUrlForShow () {

        return OpenApiConst.URL_SHOW + OpenApiConst.SERVICE_KEY;
    }

    /**
     *
     * @return 공연 장소 리스트 기본 URL
     */
    public String setBaseUrlForPlace (){
        return OpenApiConst.URL_PLACE + OpenApiConst.SERVICE_KEY ;
    }

    /**
     *
     * @param ststype 날짜 타입 : month(월별), week(주별), day(일별)
     * @param date 기준 연도
     * @param catecode 카테 고리 : AAAA(연극), GGGA(뮤지컬)
     * @return 박스 오피스 순 목록 URL
     */
    private String makeBasicUrl (String ststype, String date, String catecode) {

        return setBaseUrlForShow() + "&ststype=" + ststype + "&date=" + date + "&catecode=" + catecode;
    }

    /**
     *
     * @param showId 공연 ID
     * @return 공연 상세 URL
     */
    private String makeDetailUrl (String showId){
        return OpenApiConst.URL_DETAIL + "/" + showId + OpenApiConst.SERVICE_KEY;
    }

    public List<BoxofsDto> fetch (String url) {
        log.info("요청 url = {}" , url);

        // open api 에서 받은 데이터 (xml -> json 파싱 -> BoxofsDto)
        List<BoxofsDto> result = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject(url, String.class);

        String response = restTemplate.getForObject(url, String.class);
        // XML을 JSON Object로 변환하기
        JSONObject jobj = XML.toJSONObject(response);
        // 3. 데이터에서 꺼내어쓰기
        JSONObject jobj1 = jobj.getJSONObject("boxofs");

        JSONArray jarr = jobj1.getJSONArray("boxof");

        for (Object j : jarr) {
            JSONObject item = (JSONObject) j;
            BoxofsDto dto = makeBoxofsDto(item);
//            log.info("{}",makeBoxofsDto(item));
            if (dto != null) result.add(dto);
        }
        log.info("fetch 성공 = {}", result);
        return result;
    }

    public DetailDto fetchD (String url) {
        log.info("요청 url = {}" , url);

        // open api 에서 받은 데이터 (xml -> json 파싱 -> BoxofsDto)
        List<BoxofsDto> result = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        //String response = restTemplate.getForObject(url, String.class);

        String response = restTemplate.getForObject(url, String.class);
        // XML을 JSON Object로 변환하기
        JSONObject jobj = XML.toJSONObject(response);
        // 3. 데이터에서 꺼내어쓰기
        JSONObject jobj1 = jobj.getJSONObject("dbs").getJSONObject("db");

        DetailDto dto = makeDetailDto(jobj1);
        log.info("fetchByDetail 성공 = {}", result);

        return dto;
    }

    /**
     *
     * @param data open api 를 통해 전달받은 데이터 (JSON)
     * @return BoxofsDto
     */
    public BoxofsDto makeBoxofsDto (JSONObject data){

        return BoxofsDto.builder()
                .area(data.has("area") ? (String) data.get("area") : null)
                .cate(data.has("cate") ? (String) data.get("cate") : null)
                .prfnm(data.has("prfnm") ? (String) data.get("prfnm") : null)
                .prfpd(data.has("prfpd") ? (String) data.get("prfpd") : null)
                .mt20id(data.has("mt20id") ? (String) data.get("mt20id") : null)
                .rnum(data.has("rnum") ? (int) data.get("rnum") : null)
                .poster(data.has("poster") ? "http://kopis.or.kr/" + (String) data.get("poster"): null) // poster 사진 경로
                .prfdtcnt(data.has("prfdtcnt") ? (int) data.get("prfdtcnt") : null)
                .prfplcnm(data.has("prfplcnm") ? (String) data.get("prfplcnm") : null)
                .seatcnt(data.has("seatcnt") ? (int) data.get("seatcnt") : null)
                .build();
    }

    /**
     *
     * @param data open api 를 통해 전달받은 데이터 (JSON)
     * @return DetailDto
     */
    public DetailDto makeDetailDto (JSONObject data){
        return DetailDto.builder()
                .entrpsnm(data.has("entrpsnm") ? (String) data.get("entrpsnm") : null)
                .fcltynm(data.has("fcltynm") ? (String) data.get("fcltynm") : null)
                .genrenm(data.has("genrenm") ? (String) data.get("genrenm") : null)
                .mt10id(data.has("mt10id") ? (String) data.get("mt10id") : null)
                .openrun(data.has("openrun") ? (String) data.get("openrun") : null)
                .prfage(data.has("prfage") ? (String) data.get("prfage") : null)
                .prfcast(data.has("prfcast") ? (String) data.get("prfcast") : null)
                .prfcrew(data.has("prfcrew") ? (String) data.get("prfcrew") : null)
                .dtguidance(data.has("dtguidance") ? (String) data.get("dtguidance") : null)
                .pcseguidance(data.has("pcseguidance") ? (String) data.get("pcseguidance") : null)
                .prfpdto(data.has("prfpdto") ? (String) data.get("prfpdto") : null)
                .prfruntime(data.has("prfruntime") ? (String) data.get("prfruntime") : null)
                .prfpdfrom(data.has("prfpdfrom") ? (String) data.get("prfpdfrom") : null)
                .sty(data.has("sty") ? (String) data.get("sty") : null)
                .prfstate(data.has("prfstate") ? (String) data.get("prfstate") : null)
                .prfnm(data.has("prfnm") ? (String) data.get("prfnm") : null)
                .poster(data.has("poster") ? (String) data.get("poster") : null)
                .mt20id(data.has("mt20id") ? (String) data.get("mt20id") : null)
                .build();
    }
}
