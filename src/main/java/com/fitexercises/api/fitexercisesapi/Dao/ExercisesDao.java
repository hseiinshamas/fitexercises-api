package com.fitexercises.api.fitexercisesapi.Dao;

import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisesDao extends MongoRepository<Exercises, ObjectId>, QuerydslPredicateExecutor<Exercises> {

    //in this custom query method findExercisesByCriteria uses a $or query to match any of
    // the specified criteria (name, difficulty, force, and equipment). The @RequestParam annotations
    // in the controller method allow users to provide these parameters in the URL.
    @Query("{" +
            "?#{null == #name ? ' ' : 'name': {$regex: ?0, $options: 'i'}}, " +
            "?#{null == #level ? ' ' : 'level': {$regex: ?1, $options: 'i'}}, " +
            "?#{null == #force ? ' ' : 'force': {$regex: ?2, $options: 'i'}}, " +
            "?#{null == #equipment ? ' ' : 'equipment': {$regex: ?3, $options: 'i'}}, " +
            "?#{null == #mechanic ? ' ' : 'mechanic': {$regex: ?4, $options: 'i'}}" +
            "}")
    List<Exercises> filterByOptions(String name, String level, String force, String equipment, String mechanic);
}
