package com.myorg.cbs.controller;

import com.myorg.cbs.ServiceUri;
import com.myorg.cbs.dtos.Court;
import com.myorg.cbs.entities.CourtEntity;
import com.myorg.cbs.entities.GameEntity;
import com.myorg.cbs.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourtController {

    @Autowired
    private CourtService courtService;

    @GetMapping(ServiceUri.COURT_BASE_URL)
    private List<Court> getAllCourts() {
        return courtService.getAllCourts();
    }

    @GetMapping(ServiceUri.COURT_BY_ID_URL)
    private Court getCourt(@PathVariable("id") int id) {
        return courtService.getCourtById(id);
    }

    @DeleteMapping(ServiceUri.COURT_BY_ID_URL)
    private void deleteCourt(@PathVariable("id") int id) {
        courtService.delete(id);
    }

    @PostMapping(ServiceUri.COURT_BASE_URL)
    private int saveCourt(@RequestBody Court court) throws Exception {
        courtService.saveOrUpdate(court);
        return court.getCourtId();
    }
}
