package com.example.mesplats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import java.util.List

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Insert
    fun insert(vararg recipe: Recipe)

    @Delete
    fun delete(ingredient: Recipe)

    @Query("SELECT * FROM recipe WHERE name LIKE :queryName")
    fun findByName(queryName: String): Recipe

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryId")
    fun findById(queryId: Int): Recipe
}