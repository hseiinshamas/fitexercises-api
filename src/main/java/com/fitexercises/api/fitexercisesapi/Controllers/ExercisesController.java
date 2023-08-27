package com.fitexercises.api.fitexercisesapi.Controllers;

import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import com.fitexercises.api.fitexercisesapi.Services.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
@CrossOrigin
public class ExercisesController {

    @Autowired
    private ExercisesService exercisesService;

    @GetMapping // Return all the Exercises.
    public ResponseEntity<List<Exercises>> getAllExercises() {
        return new ResponseEntity<List<Exercises>>(exercisesService.getAllExercises(), HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Exercises>> getExerciseByName(@RequestParam String name) {
        List<Exercises> exercises = exercisesService.getExerciseByName(name);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }


    @GetMapping("/searchByCategory")
    public ResponseEntity<List<Exercises>> getExerciseByCategory(@RequestParam String category) {
        List<Exercises> exercises = exercisesService.getExerciseByCategory(category);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/searchByLevel")
    public ResponseEntity<List<Exercises>> getExerciseByLevel(@RequestParam String level) {
        List<Exercises> exercises = exercisesService.getExerciseByLevel(level);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/searchByForce")
    public ResponseEntity<List<Exercises>> getExerciseByForce(@RequestParam String force) {
        List<Exercises> exercises = exercisesService.getExerciseByForce(force);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/searchByMechanic")
    public ResponseEntity<List<Exercises>> getExerciseByMechanic(@RequestParam String mechanic) {
        List<Exercises> exercises = exercisesService.getExerciseByMechanic(mechanic);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/searchByEquipment")
    public ResponseEntity<List<Exercises>> getExerciseByEquipment(@RequestParam String equipment) {
        List<Exercises> exercises = exercisesService.getExerciseByEquipment(equipment);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
