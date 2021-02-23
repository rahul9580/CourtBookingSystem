package com.myorg.cbs.service;

import com.myorg.cbs.converter.ObjectConverter;
import com.myorg.cbs.dao.AcademyDao;
import com.myorg.cbs.dtos.Academy;
import com.myorg.cbs.entities.AcademyEntity;
import com.myorg.cbs.entities.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AcademyService {

    @Autowired
    private AcademyDao academyDao;

    @Autowired
    private CityService cityService;

    public List<Academy> getAllAcademies() {
        List<Academy> academies = new ArrayList<>();
        List<AcademyEntity> academyEntities = academyDao.getAllAcademies();
        if(Objects.nonNull(academyEntities)) {
            academies = ObjectConverter.convertAcademyEntities(academyEntities);
        }
        return academies;
    }

    public Academy getAcademyById(int id) {
        Academy academy = null;
        AcademyEntity academyEntity = academyDao.getAcademyById(id);
        if(Objects.nonNull(academyEntity)) {
            academy = ObjectConverter.convertAcademyEntity(academyEntity);
        }
        return academy;
    }

    public void saveOrUpdate(Academy academy) throws Exception {
        CityEntity cityEntity = cityService.getCityById(academy.getCityId());
        if(Objects.isNull(cityEntity)) {
            throw new Exception("City is not servicable.");
        }
        AcademyEntity academyEntity = ObjectConverter.convertAcademy(academy);
        academyEntity.setCityEntity(cityEntity);
        academyDao.saveOrUpdate(academyEntity);
    }

    public void delete(int id) {
        academyDao.delete(id);
    }

    public List<Academy> getAcademiesByCityId(int cityId) {
        List<Academy> academies = new ArrayList<>();
        List<AcademyEntity> academyEntities = academyDao.getAcademiesByCityId(cityId);
        if(Objects.nonNull(academyEntities)) {
            academies = ObjectConverter.convertAcademyEntities(academyEntities);
        }
        return academies;
    }
}
