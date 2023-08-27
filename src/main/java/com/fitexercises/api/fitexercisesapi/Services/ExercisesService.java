package com.fitexercises.api.fitexercisesapi.Services;


import com.fitexercises.api.fitexercisesapi.Dao.ExercisesDao;
import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExercisesService {

    @Autowired
    private ExercisesDao exercisesDao;

    @Autowired
    private MongoTemplate mongoTemplate;


    //  Return all the exercises in the db
    public List<Exercises> getAllExercises() {
        return exercisesDao.findAll();
    }


    /*While Spring Data repositories are great for standard CRUD operations,
    the MongoTemplate is useful for scenarios where you need to perform operations that
    are beyond the capabilities of repositories, such as performing joins across collections
     or dynamic queries based on user input.

     */
    public List<Exercises> getExerciseByOption(String name, String force, String level, String equipment, String mechanic) {
        Query query = new Query();

        if (name != null) {

            Criteria nameCriteria = Criteria.where("name").regex(name, "i");
            query.addCriteria(nameCriteria);
        }

        if (force != null) {

            Criteria forceCriteria = Criteria.where("force").regex(force, "i");
            query.addCriteria(forceCriteria);
        }

        if (level != null) {
            Criteria levelCriteria = Criteria.where("level").regex(level, "i");
            query.addCriteria(levelCriteria);
        }

        if (force != null) {
            Criteria forceCriteria = Criteria.where("force").regex(force, "i");
            query.addCriteria(forceCriteria);
        }

        if (equipment != null) {
            Criteria equipmentCriteria = Criteria.where("equipment").regex(equipment, "i");
            query.addCriteria(equipmentCriteria);
        }


        return mongoTemplate.find(query, Exercises.class);
    }
}
