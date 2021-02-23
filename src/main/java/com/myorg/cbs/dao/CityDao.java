package com.myorg.cbs.dao;

import com.myorg.cbs.database.Database;
import com.myorg.cbs.entities.CityEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class CityDao {
    public List<CityEntity> getAllCities() {
        List<CityEntity> cityEntities = new ArrayList<>();
        for(Map.Entry<Integer, CityEntity> entity : Database.cityTable.entrySet()) {
            cityEntities.add(entity.getValue());
        }
        return cityEntities;
    }

    public CityEntity getCityById(int id) {
        return Database.cityTable.get(id);
    }

    public void saveOrUpdate(CityEntity cityEntity) {
        Database.cityTable.put(cityEntity.getCityId(), cityEntity);
    }

    public void delete(int id) {
        Database.cityTable.remove(id);
    }
}
