package com.myorg.cbs.dtos;

import com.myorg.cbs.entities.CourtEntity;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class Academy {
    private int academyId;
    private List<CourtEntity> courts;
    private int cityId;
    private LocalTime openTime;
    private LocalTime closeTime;
    private String academyName;
    private String ownerName;
    private String ownerEmail;
    private String address;
}
