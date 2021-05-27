package com.example.favdash.model.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.favdash.model.entities.FavDish
import kotlinx.coroutines.flow.Flow

@Dao
interface FavDishDao {
    //Using couroutines - suspend is simalar to async in another languages
    @Insert suspend fun insertFavDishDetails(favDish: FavDish)

    @Query("SELECT * FROM FAV_DISHES_TABLE ORDER BY ID")
    fun getAllDishesList(): Flow<List<FavDish>>
    //Flow is an coroutines interface that is reative to work asynchronous flows
}