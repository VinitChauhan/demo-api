package com.learning.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Document(collection = "Locations")
@Data
public class Location {
    @Id
    private Integer id;
    @NotNull(message = "Street can not be empty")
    private String street;
    @NotNull(message = "City can not be empty")
    private String city;
    @NotNull(message = "State can not be empty")
    private String state;
    @NotNull(message = "Pin can not be empty")
    @Pattern(regexp = "^\\d{5}$",message = "Pin should be minimum 5 digits long")
    private String pin;
}
