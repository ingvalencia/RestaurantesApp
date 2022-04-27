package com.gvalencia.restaurantesapp.domain


import com.gvalencia.restaurantesapp.data.model.RestauranteList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("DetalleRestaurante")

    suspend fun getRestaurante(@Query("Restaurante") Restaurante:String): RestauranteList



}