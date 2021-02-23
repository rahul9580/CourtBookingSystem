package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.entities.CityEntity;
import com.myorg.cbs.entities.CourtEntity;
import com.myorg.cbs.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(ServiceUri.CITY_BASE_URL)
    private List<CityEntity> getAllCities() {
        return cityService.getAllCities();
    }

    @GetMapping(ServiceUri.CITY_BY_ID_URL)
    private CityEntity getGame(@PathVariable("id") int id) {
        return cityService.getCityById(id);
    }

    @DeleteMapping(ServiceUri.CITY_BY_ID_URL)
    private void deleteGame(@PathVariable("id") int id) {
        cityService.delete(id);
    }

    @PostMapping(ServiceUri.CITY_BASE_URL)
    private int saveCity(@RequestBody CityEntity city) {
        cityService.saveOrUpdate(city);
        return city.getCityId();
    }
}
