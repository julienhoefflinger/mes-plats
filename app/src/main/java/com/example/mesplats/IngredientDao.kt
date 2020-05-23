package com.example.mesplats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface IngredientDao {

    @Query("SELECT * FROM ingredient ORDER BY name")
    fun getAll(): List<Ingredient>

    @Insert
    fun insert(vararg ingredient: Ingredient)

    @Query("DELETE FROM ingredient")
    fun deleteAll()

    @Delete
    fun delete(ingredient: Ingredient)

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryName")
    fun findByName(queryName: String): Ingredient

    @Query("SELECT * FROM ingredient WHERE name LIKE :queryId")
    fun findById(queryId: Int): Ingredient
}