package com.rup.rup_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetPointRecord {
    public String uid;
    public String date;
    public int point;
}
