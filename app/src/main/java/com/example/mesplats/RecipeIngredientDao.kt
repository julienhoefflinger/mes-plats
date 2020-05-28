package com.example.mesplats

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecipeIngredientDao {

    @Query("SELECT * FROM recipeIngredient")
    fun getAll(): List<RecipeIngredient>

    @Insert
    fun insert(vararg recipe: RecipeIngredient)

    @Delete
    fun delete(ingredient: RecipeIngredient)

    @Query("SELECT * FROM recipeIngredient WHERE recipeId LIKE :queryName")
    fun findIngredientsByRecipe(queryName: Int): RecipeIngredient
}