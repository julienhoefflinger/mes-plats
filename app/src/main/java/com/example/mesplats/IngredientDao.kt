package com.example.mesplats

import androidx.room.*

@Dao
interface IngredientDao {

    @Query("SELECT * FROM ingredient ORDER BY name")
    fun getAll(): List<Ingredient>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg ingredient: Ingredient)

    @Query("DELETE FROM ingredient")
    fun deleteAll()

    @Delete
    fun delete(ingredient: Ingredient)

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryName")
    fun findByName(queryName: String): List<Ingredient>

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryId")
    fun findById(queryId: Int): Ingredient
}