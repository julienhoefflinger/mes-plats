package com.example.mesplats

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = arrayOf(
        ForeignKey(
            entity = Ingredient::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("ingredient_id"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Recipe::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("recipe_id"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class Recipe_ingredient (val quantity: Int) {
//    @PrimaryKey(autoGenerate = true)
//    val id: Int,
    val ingredient_id: Int = 0
    val recipe_id: Int = 0
}