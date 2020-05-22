package com.example.mesplats

import androidx.room.*

@Dao
interface RecipeDao {

    @Query("SELECT * FROM recipe")
    fun getAll(): List<Recipe>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg recipe: Recipe)

    @Delete
    fun delete(ingredient: Recipe)

    @Query("DELETE FROM recipe")
    fun deleteAll()

    @Query("SELECT * FROM recipe WHERE name LIKE :queryName")
    fun findByName(queryName: String): Recipe

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryId")
    fun findById(queryId: Int): Recipe
}