package com.rup.rup_backend.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoticeAndPointRecord<records> {
    private String noticeDate;
    private String title;
    private String notice;
    private records pointRecord;
}
