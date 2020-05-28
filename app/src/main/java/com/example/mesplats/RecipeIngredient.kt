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
            childColumns = arrayOf("ingredientId"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Recipe::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("recipeId"),
            onDelete = ForeignKey.CASCADE
        )
    )
)
data class RecipeIngredient (val quantity: Int, val ingredientId: Int, val recipeId: Int, val unit: String) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

//    fun getId: Int {
//        return id
//    }
}