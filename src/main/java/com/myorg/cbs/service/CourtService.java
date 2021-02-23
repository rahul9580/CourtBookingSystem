package com.myorg.cbs.service;

import com.myorg.cbs.converter.ObjectConverter;
import com.myorg.cbs.dao.CourtDao;
import com.myorg.cbs.dtos.Academy;
import com.myorg.cbs.dtos.Court;
import com.myorg.cbs.dtos.Game;
import com.myorg.cbs.entities.CourtEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CourtService {

    @Autowired
    private CourtDao courtDao;

    @Autowired
    private AcademyService academyService;

    @Autowired
    private GameService gameService;

    public List<Court> getAllCourts() {
        List<CourtEntity> courtEntities = courtDao.getAllCourts();
        List<Court> courts = new ArrayList<>();
        if(Objects.nonNull(courtEntities)) {
            courts = ObjectConverter.convertCourtEntities(courtEntities);
        }
        return courts;
    }

    public Court getCourtById(int id) {
        CourtEntity courtEntity = courtDao.getCourtById(id);
        Court court = null;
        if(Objects.nonNull(courtEntity)) {
            court = ObjectConverter.convertCourtEntity(courtEntity);
        }
        return court;
    }

    public void saveOrUpdate(Court court) throws Exception {
        Academy academy = academyService.getAcademyById(court.getAcademyId());
        if(Objects.isNull(academy)) {
            throw new Exception("Academy does not exists.");
        }
        Game game = gameService.getGameById(court.getGameId());
        if(Objects.isNull(game)) {
            throw new Exception("Game does not exists.");
        }
        CourtEntity courtEntity = ObjectConverter.convertCourt(court);
        courtEntity.setAcademyEntity(ObjectConverter.convertAcademy(academy));
        courtEntity.setGameEntity(ObjectConverter.convertGame(game));

        courtDao.saveOrUpdate(courtEntity);
    }

    public void delete(int id) {
        courtDao.delete(id);
    }
}
