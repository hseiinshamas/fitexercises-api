package com.fitexercises.api.fitexercisesapi.Services;


import com.fitexercises.api.fitexercisesapi.Dao.ExercisesDao;
import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesDao exercisesDao;


    // Apply the @Cacheable annotation to the methods in your service class that retrieve
    // data from the database.
    // The annotation indicates that the method's results should be cached.

    @Cacheable("exercisesCache")
    public List<Exercises> getAllExercises() {
        return exercisesDao.findAll();
    }


    public List<Exercises> getExerciseByName(String name) {
        return exercisesDao.findByPartialNameIgnoreCase(name);
    }

    public List<Exercises> getExerciseByCategory(String category) {
        return exercisesDao.findByCategory(category);
    }

    public List<Exercises> getExerciseByLevel(String level) {
        return exercisesDao.findByLevel(level);

    }

    public List<Exercises> getExerciseByForce(String force) {
        return exercisesDao.findByForce(force);

    }

    public List<Exercises> getExerciseByMechanic(String mechanic) {
        return exercisesDao.findByMechanic(mechanic);

    }

    public List<Exercises> getExerciseByEquipment(String equipment) {
        return exercisesDao.findByEquipment(equipment);

    }


    @Cacheable("exercisesCache")
    public List<Exercises> filterExercises(String criteria, String value) {
        return switch (criteria.toLowerCase()) {
            case "name" -> exercisesDao.findByNameIgnoreCaseContaining(value);
            case "level" -> exercisesDao.findByLevelIgnoreCaseContaining(value);
            case "force" -> exercisesDao.findByForceIgnoreCaseContaining(value);
            case "mechanic" -> exercisesDao.findByMechanicIgnoreCaseContaining(value);
            case "equipment" -> exercisesDao.findByEquipmentIgnoreCaseContaining(value);
            case "category" -> exercisesDao.findByCategoryIgnoreCaseContaining(value);
            default -> throw new IllegalArgumentException("Invalid criteria: " + criteria);
        };
    }

}
