package com.musicaltogether.mugether.user.domain;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity(name = "show_bookmarks")
@Table(name = "show_bookmarks")
@Getter
public class BookMark {

    @Id @GeneratedValue
    @Column(name = "bookMark_id")
    private Long id;

    @Setter
    private String userId;

    @Setter
    private Boolean status ;

    /**
     * 연관관계의 주인으로 잡는다.
     */
    @ManyToOne(fetch = FetchType.LAZY) // x to one 인 경우 default 가 EAGER 이다. LAZY 비꾸는거 중요함
    @JoinColumn(name = "show_id", nullable = false) // fk
    @Setter
    private Show show;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private User user;

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDateTime createDate; // 날짜

    @PrePersist
    public void createDate(){
        this.createDate = LocalDateTime.now();
    }

    /**
     * 연관관계 메서드
     */
    public void setShow (Show show){
        this.show = show;
        show.getShowBookMarks().add(this);
    }

    // 생성 메서드
    public static BookMark createBookMark(Show show, String userId){

        BookMark bookMark = new BookMark();
        bookMark.setShow(show);
        bookMark.createDate(); // 날짜 생성
        bookMark.setStatus(true);
        bookMark.setUserId(userId);

        if (show.getBMarkCnt() == null || show.getBMarkCnt() == 0) show.setBMarkCnt(1);
        return bookMark;
    }


    /**
     * 북마크 cnt (북마크를 추가한다.)
     * @param show
     */
    public void updateBookMark(Show show){
        this.show = show;
//        this.user = user;
        this.userId = "testId";
        this.status = true;
        this.show.setBMarkCnt(show.getBMarkCnt()+1);
    }

    /**
     * 북마크 cnt (북마크를 삭제한다.)
     * @param show
     */
    public void updateUnBookMark(Show show){
        this.show.setBMarkCnt(show.getBMarkCnt()-1);
        this.status = false;
    }

}
