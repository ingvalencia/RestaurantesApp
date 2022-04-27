package com.gvalencia.restaurantesapp.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.gvalencia.restaurantesapp.domain.Repo
import com.gvalencia.restaurantesapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo:Repo):ViewModel(){

    val fetchRestauranteList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repo.getRestaurantesLista(""))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }
}