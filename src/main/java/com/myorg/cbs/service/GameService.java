package com.myorg.cbs.service;

import com.myorg.cbs.converter.ObjectConverter;
import com.myorg.cbs.dao.GameDao;
import com.myorg.cbs.dtos.Game;
import com.myorg.cbs.entities.GameEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class GameService {

    @Autowired
    private GameDao gameDao;

    public List<Game> getAllGames() {
        List<GameEntity> gameEntities = gameDao.getAllGames();
        List<Game> games = new ArrayList<>();
        if(Objects.nonNull(gameEntities)) {
            games = ObjectConverter.convertGameEntities(gameEntities);
        }
        return games;
    }

    public Game getGameById(int id) {
        GameEntity gameEntity = gameDao.getGameById(id);
        Game game = null;
        if(Objects.nonNull(gameEntity)) {
            game = ObjectConverter.convertGameEntity(gameEntity);
        }
        return game;
    }

    public void saveOrUpdate(Game game) {
        gameDao.saveOrUpdate(ObjectConverter.convertGame(game));
    }

    public void delete(int id) {
        gameDao.delete(id);
    }
}
