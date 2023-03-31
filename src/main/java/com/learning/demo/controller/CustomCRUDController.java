package com.learning.demo.controller;

import com.learning.demo.model.Location;
import com.learning.demo.repositories.CustomCRUDRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/demo")
public class CustomCRUDController {
    @Autowired
    CustomCRUDRepository customCRUDRepository;
    @GetMapping
    public List<Location> findAllLocation() {
        return customCRUDRepository.findAll();
    }
    @PostMapping("/add")
    public List<Location> addLocation(@RequestBody Location location) {
        Location loc = customCRUDRepository.save(location);
        log.info("Record Created :  {}", loc);
        return customCRUDRepository.findAll();
    }

    @PutMapping("/update")
    public List<Location> updateLocation(@RequestBody Location location){
        Location loc = customCRUDRepository.save(location);
        log.info("Record Updated :  {}", loc);
        return customCRUDRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public List<Location> deleteLocation(@PathVariable Integer id) {
        customCRUDRepository.deleteById(id);
        log.info("Record Deleted :  {}", id);
        return customCRUDRepository.findAll();
    }

}
