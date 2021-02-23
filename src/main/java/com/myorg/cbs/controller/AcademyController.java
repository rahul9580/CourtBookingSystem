package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.dtos.Academy;
import com.myorg.cbs.entities.AcademyEntity;
import com.myorg.cbs.entities.CityEntity;
import com.myorg.cbs.service.AcademyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcademyController {
    @Autowired
    private AcademyService academyService;

    @GetMapping(ServiceUri.ACADEMY_BASE_URL)
    private List<Academy> getAllAcademies() {
        return academyService.getAllAcademies();
    }

    @GetMapping(ServiceUri.ACADEMY_BY_ID_URL)
    private Academy getAcademy(@PathVariable("id") int id) {
        return academyService.getAcademyById(id);
    }

    @DeleteMapping(ServiceUri.ACADEMY_BY_ID_URL)
    private void deleteAcademy(@PathVariable("id") int id) {
        academyService.delete(id);
    }

    @PostMapping(ServiceUri.ACADEMY_BASE_URL)
    private int saveAcademy(@RequestBody Academy academy) throws Exception {
        academyService.saveOrUpdate(academy);
        return academy.getAcademyId();
    }

    @GetMapping(ServiceUri.ACADEMY_BY_CITY_ID_URL)
    private List<Academy> getAcademiesByCityId(@PathVariable("cityId") int cityId) {
        return academyService.getAcademiesByCityId(cityId);
    }
}
