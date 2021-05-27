package com.example.favdash.application

import android.app.Application
import com.example.favdash.model.database.FavDishRepository
import com.example.favdash.model.database.FavDishRoomDatabase

class FavDishApplication: Application() {

    //First create a database
    private val database by lazy {
        FavDishRoomDatabase.getDatabase(this@FavDishApplication)
    }

    //After create a repository
    val repository by lazy {
        FavDishRepository(database.favDishDao())
    }
}