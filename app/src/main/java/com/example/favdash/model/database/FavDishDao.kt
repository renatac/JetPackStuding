package com.example.favdash.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.favdash.model.entities.FavDish

@Dao
interface FavDishDao {
    //Using couroutines - suspend is simalar to async in another languages
    @Insert
    suspend fun insertFavDishDetails(favDish: FavDish)
}