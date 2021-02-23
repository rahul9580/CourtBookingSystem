package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.AcademyEntity;
import com.myorg.cbs.entities.CourtEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CourtDao {

    public List<CourtEntity> getAllCourts() {
        List<CourtEntity> courtEntities = new ArrayList<>();
        for(Map.Entry<Integer, CourtEntity> entity : Database.courtTable.entrySet()) {
            courtEntities.add(entity.getValue());
        }
        return courtEntities;
    }

    public CourtEntity getCourtById(int id) {
        return Database.courtTable.get(id);
    }

    public void saveOrUpdate(CourtEntity courtEntity) {
        Database.courtTable.put(courtEntity.getCourtId(), courtEntity);
    }

    public void delete(int id) {
        Database.courtTable.remove(id);
    }
}
