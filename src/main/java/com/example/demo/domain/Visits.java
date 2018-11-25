package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@AllArgsConstructor
public class Visits {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private Long id;

    @Column
    private String url;

    @Column
    private LocalDateTime visitedDate;

    @Builder
    public Visits(Long id, String url, LocalDateTime visitedDate) {
        this.id = id;
        this.url = url;
        this.visitedDate = visitedDate;
    }
}
