package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.AcademyEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AcademyDao {

    public List<AcademyEntity> getAllAcademies() {
        List<AcademyEntity> academyEntities = new ArrayList<>();
        for(Map.Entry<Integer, AcademyEntity> entity : Database.academyTable.entrySet()) {
            academyEntities.add(entity.getValue());
        }
        return academyEntities;
    }

    public AcademyEntity getAcademyById(int id) {
        return Database.academyTable.get(id);
    }

    public void saveOrUpdate(AcademyEntity academy) throws Exception {
        Database.academyTable.put(academy.getAcademyId(), academy);
    }

    public void delete(int id) {
        Database.academyTable.remove(id);
    }

    public List<AcademyEntity> getAcademiesByCityId(int cityId) {
        List<AcademyEntity> academyEntities = getAllAcademies();

        List<AcademyEntity> academiesInCity = new ArrayList<>();
        for(AcademyEntity academyEntity : academyEntities) {
            if(academyEntity.getCityEntity().getCityId() == cityId) {
                academiesInCity.add(academyEntity);
            }
        }
        return academiesInCity;
    }
}
