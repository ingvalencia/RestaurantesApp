package com.gvalencia.restaurantesapp.domain

import com.gvalencia.restaurantesapp.data.model.Restaurante
import com.gvalencia.restaurantesapp.vo.Resource

interface Repo {

   suspend fun getRestaurantesLista(restaurante:String):Resource<List<Restaurante>>

}