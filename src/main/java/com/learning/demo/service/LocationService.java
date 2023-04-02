package com.learning.demo.service;

import com.learning.demo.exceptions.DuplicateLocationException;
import com.learning.demo.exceptions.LocationNotFoundException;
import com.learning.demo.model.Location;
import com.learning.demo.repositories.CustomCRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    CustomCRUDRepository customCRUDRepository;

    public Location createLocation(Location location) throws DuplicateLocationException {
        try {
            return customCRUDRepository.insert(location);
        } catch (DuplicateKeyException ex) {
            throw new DuplicateLocationException("Location already exist in database");
        }
    }

    public Location updateLocation(Location location) throws LocationNotFoundException {
        Optional<Location> loc = customCRUDRepository.findById(location.getId());
        if (loc.isPresent()) {
            return customCRUDRepository.save(location);
        } else {
            throw new LocationNotFoundException("Location does not exist in database");
        }
    }

    public List<Location> findAll() {
        return customCRUDRepository.findAll();
    }

    public void deleteById(Integer id) throws LocationNotFoundException {
        Optional<Location> location = customCRUDRepository.findById(id);
        if (location.isPresent()) {
            customCRUDRepository.deleteById(id);
        } else {
            throw new LocationNotFoundException("Location does not exist in database");
        }
    }
}
