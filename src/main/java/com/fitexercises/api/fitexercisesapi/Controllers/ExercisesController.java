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

    @GetMapping("/search")// Get an exercise based on the options found.
    public ResponseEntity<List<Exercises>> getExerciseByOption(@RequestParam (required = false) String name, @RequestParam (required = false) String level, @RequestParam (required = false) String force, @RequestParam (required = false) String equipment, @RequestParam (required = false) String mechanic) {
        List<Exercises> exercises = exercisesService.getExerciseByOption(name, level, force, equipment, mechanic);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
}
