package com.rup.rup_backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="notice_record")
@NoArgsConstructor
@Getter
public class Notice {
    @Id
    private int idx;
    private String date;
    private String title;
    private String notice;
}
