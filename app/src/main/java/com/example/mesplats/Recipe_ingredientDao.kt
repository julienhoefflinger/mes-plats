package com.example.mesplats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import java.util.List

@Dao
interface Recipe_ingredientDao {

    @Query("SELECT * FROM recipe_ingredient")
    fun getAll(): List<Recipe_ingredient>

    @Insert
    fun insert(vararg recipe: Recipe_ingredient)

    @Delete
    fun delete(ingredient: Recipe_ingredient)

    @Query("SELECT * FROM recipe_ingredient WHERE recipe_id LIKE :queryName")
    fun findIngredientsByRecipe(queryName: Int): Recipe_ingredient
}