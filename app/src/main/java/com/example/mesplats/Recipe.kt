package com.example.mesplats

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Recipe (val name: String) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}