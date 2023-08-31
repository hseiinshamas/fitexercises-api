package com.fitexercises.api.fitexercisesapi.repository;

import com.fitexercises.api.fitexercisesapi.Models.Exercises;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExercisesRepository extends MongoRepository<Exercises, ObjectId> {

    @Query("{'name': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByPartialNameIgnoreCase(String name);

    @Query("{'category': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByCategory(String category);

    @Query("{'level': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByLevel(String level);

    @Query("{'force': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByForce(String force);

    @Query("{'mechanic': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByMechanic(String mechanic);

    @Query("{'equipment': {$regex: ?0, $options: 'i'}}")
    List<Exercises> findByEquipment(String equipment);


    List<Exercises> findByNameIgnoreCaseContaining(String name);

    List<Exercises> findByCategoryIgnoreCaseContaining(String category);

    List<Exercises> findByLevelIgnoreCaseContaining(String level);

    List<Exercises> findByForceIgnoreCaseContaining(String force);

    List<Exercises> findByMechanicIgnoreCaseContaining(String mechanic);

    List<Exercises> findByEquipmentIgnoreCaseContaining(String equipment);

}
