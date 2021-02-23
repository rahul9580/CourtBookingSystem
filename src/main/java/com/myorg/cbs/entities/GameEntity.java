package com.myorg.cbs.entities;

import lombok.Data;

@Data
public class GameEntity {
    private int gameId;
    private String gameName;
    private byte minAge;
}
