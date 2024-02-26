package com.musicaltogether.mugether.user.domain;

import com.musicaltogether.mugether.show.domain.Show;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "show_bookMarks")
@Getter
public class BookMarks {

    @Id @GeneratedValue
    @Column(name = "bookMark_id")
    private Long id;

    private String userId;

    private boolean status;

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

    public void createBookMark(Show show){
        this.show = show;
//        this.user = user;
        this.userId = "testId";
        this.status = true;
    }
}
