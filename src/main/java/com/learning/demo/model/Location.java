package com.learning.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Locations")
@Data
public class Location {
    @Id
    private Integer id;
    private String street;
    private String city;
    private String state;
    private Integer pin;
}
