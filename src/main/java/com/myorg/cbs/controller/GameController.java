package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.dtos.Game;
import com.myorg.cbs.entities.GameEntity;
import com.myorg.cbs.entities.UserEntity;
import com.myorg.cbs.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(ServiceUri.GAME_BASE_URL)
    private List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping(ServiceUri.GAME_BY_ID_URL)
    private Game getGame(@PathVariable("id") int id) {
        return gameService.getGameById(id);
    }

    @DeleteMapping(ServiceUri.GAME_BY_ID_URL)
    private void deleteGame(@PathVariable("id") int id) {
        gameService.delete(id);
    }

    @PostMapping(ServiceUri.GAME_BASE_URL)
    private int saveGame(@RequestBody Game game) {
        gameService.saveOrUpdate(game);
        return game.getGameId();
    }

    //GetAllGamesForAcademy
}
