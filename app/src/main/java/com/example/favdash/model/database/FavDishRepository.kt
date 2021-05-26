package com.example.favdash.model.database

import androidx.annotation.WorkerThread
import com.example.favdash.model.entities.FavDish

class FavDishRepository (private val favDishDao: FavDishDao) {

    @WorkerThread
    suspend fun insertFavDishData(favDish: FavDish) {
        favDishDao.insertFavDishDetails(favDish)
    }
}