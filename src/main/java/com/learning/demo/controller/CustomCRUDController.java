package com.learning.demo.controller;

import com.learning.demo.exceptions.DuplicateLocationException;
import com.learning.demo.exceptions.LocationNotFoundException;
import com.learning.demo.model.Location;
import com.learning.demo.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class CustomCRUDController {
    @Autowired
    LocationService locationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Location> findAllLocation() {
        return locationService.findAll();
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Location> addLocation(@RequestBody @Valid Location location) throws DuplicateLocationException {
        Location loc = locationService.createLocation(location);
        log.info("Record Created :  {}", loc);
        return locationService.findAll();
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Location> updateLocation(@RequestBody @Valid Location location) throws LocationNotFoundException {
        Location loc = locationService.updateLocation(location);
        log.info("Record Updated :  {}", loc);
        return locationService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Location> deleteLocation(@PathVariable Integer id) throws LocationNotFoundException {
        locationService.deleteById(id);
        log.info("Record Deleted :  {}", id);
        return locationService.findAll();
    }

}
