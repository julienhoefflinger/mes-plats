package com.example.mesplats

import androidx.fragment.app.FragmentActivity
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities=[Ingredient::class, Recipe::class, Recipe_ingredient::class],
    version = 2
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getIngredientDAO(): IngredientDao
    abstract fun getRecipeDAO(): RecipeDao
    abstract fun getRecipeçingredientDAO(): Recipe_ingredientDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: FragmentActivity?): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    if (context != null) {
                        INSTANCE = Room
                            .databaseBuilder(context.applicationContext, AppDatabase::class.java, "db")
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE as AppDatabase
        }
    }
}
