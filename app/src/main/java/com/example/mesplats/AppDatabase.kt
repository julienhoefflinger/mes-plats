package com.example.mesplats

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities=[Ingredient::class, Recipe::class, Recipe_ingredient::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getIngredientDAO(): IngredientDao
    abstract fun getRecipeDAO(): RecipeDao
    abstract fun getRecipeçingredientDAO(): Recipe_ingredientDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room
                    .databaseBuilder(context.applicationContext, AppDatabase::class.java, "db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}
