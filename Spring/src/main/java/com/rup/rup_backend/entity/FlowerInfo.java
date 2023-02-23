package com.rup.rup_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="flower_record")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class FlowerInfo {
    @Id
    private int idx;
    private String uid;
    private String flower;
    private String flower_nickname;
    private int flower_grown_level;
    private String date;
}
