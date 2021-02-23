package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.GameEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class GameDao {

    public List<GameEntity> getAllGames() {
        List<GameEntity> gameEntities = new ArrayList<>();
        for(Map.Entry<Integer, GameEntity> entity : Database.gameTable.entrySet()) {
            gameEntities.add(entity.getValue());
        }
        return gameEntities;
    }

    public GameEntity getGameById(int id) {
        return Database.gameTable.get(id);
    }

    public void saveOrUpdate(GameEntity gameEntity) {
        Database.gameTable.put(gameEntity.getGameId(), gameEntity);
    }

    public void delete(int id) {
        Database.gameTable.remove(id);
    }
}
