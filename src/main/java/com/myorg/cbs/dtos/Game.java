package com.myorg.cbs.dtos;

import lombok.Data;

@Data
public class Game {
    private int gameId;
    private String gameName;
    private byte minAge;
}
