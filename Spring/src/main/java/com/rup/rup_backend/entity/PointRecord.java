package com.rup.rup_backend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="point_record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PointRecord {
    @Id
    private int idx;
    private String uid;
    private String date;
    private int point;
}
