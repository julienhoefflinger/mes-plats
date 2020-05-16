package com.example.mesplats;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
interface IngredientDAO {

    @Query("SELECT * FROM ingredient")
    fun getAll(): List<Ingredient>

//    @Insert
//    fun insert(vararg ingredient: Ingredient)
//
//    @Delete
//    fun delete(ingredient: Ingredient)
//
//    @Query("SELECT * FROM Ingredient WHERE name LIKE :queryName")
//    fun findByName(queryName: String): Ingredient
}