package com.fitexercises.api.fitexercisesapi.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "exercises")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exercises {

    @Id
    private String id;
    private String name;
    private String category;
    private String force;
    private String level;
    private String mechanic;
    private String equipment;
    private List<String> primaryMuscles;
    private List<String> secondaryMuscles;
    private List<String> instructions;
    private List<String> images;

}
