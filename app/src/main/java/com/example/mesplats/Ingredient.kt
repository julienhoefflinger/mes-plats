package com.example.mesplats

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Ingredient (val name: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}