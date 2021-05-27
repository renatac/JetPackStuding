package com.example.favdash.viewmodel

import androidx.lifecycle.*
import com.example.favdash.model.database.FavDishRepository
import com.example.favdash.model.entities.FavDish
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

//ViewModel is part of lifecycle library
class FavDishViewModel(private val repository: FavDishRepository): ViewModel() {

    //ViewModels survive a configuration changes, recreate activity, mantain a data...
    fun insertDish(favDish: FavDish) = viewModelScope.launch {
        repository.insertFavDishData(favDish)
    }

    val allDishesList: LiveData<List<FavDish>> = repository.allDishesList.asLiveData()
}

class FavDishViewModelFactory(private val repository: FavDishRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //T is ViewModel? optional
        if(modelClass.isAssignableFrom(FavDishViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return FavDishViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}