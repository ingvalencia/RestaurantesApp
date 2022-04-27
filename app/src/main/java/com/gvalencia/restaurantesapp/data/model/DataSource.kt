package com.gvalencia.restaurantesapp.data.model

import com.gvalencia.restaurantesapp.vo.Resource
import com.gvalencia.restaurantesapp.vo.RetrofitClient

class DataSource {

    suspend fun getRestaurante(restaurante:String):Resource<List<Restaurante>>{
        return Resource.Success(RetrofitClient.webservice.getRestaurante(restaurante).restauranteList)
    }


}