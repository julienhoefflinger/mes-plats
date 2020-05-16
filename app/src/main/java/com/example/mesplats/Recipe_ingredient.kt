package com.example.mesplats

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

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
data class Recipe_ingredient (val quantity: Int, val ingredient_id: Int, val recipe_id: Int) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}