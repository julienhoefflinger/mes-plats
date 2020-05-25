package com.example.mesplats

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(indices = arrayOf(Index(value = ["name"], unique = true)))
data class Ingredient (val name: String) : Serializable{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}