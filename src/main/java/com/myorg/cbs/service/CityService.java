package com.myorg.cbs.service;

import com.myorg.cbs.dao.CityDao;
import com.myorg.cbs.entities.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public List<CityEntity> getAllCities() {
        return cityDao.getAllCities();
    }

    public CityEntity getCityById(int id) {
        return cityDao.getCityById(id);
    }

    public void saveOrUpdate(CityEntity cityEntity) {
        cityDao.saveOrUpdate(cityEntity);
    }

    public void delete(int id) {
        cityDao.delete(id);
    }
}
