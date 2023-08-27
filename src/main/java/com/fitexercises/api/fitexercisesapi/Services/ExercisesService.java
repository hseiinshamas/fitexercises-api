package com.fitexercises.api.fitexercisesapi.Services;


import com.fitexercises.api.fitexercisesapi.Dao.ExercisesDao;
import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesDao exercisesDao;


    //  Return all the exercises in the db
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

}
