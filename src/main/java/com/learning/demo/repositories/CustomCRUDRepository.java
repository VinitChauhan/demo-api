package com.learning.demo.repositories;

import com.learning.demo.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomCRUDRepository extends MongoRepository<Location, Integer> {
}
