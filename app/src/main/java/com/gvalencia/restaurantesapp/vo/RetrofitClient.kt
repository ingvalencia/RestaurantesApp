package com.gvalencia.restaurantesapp.vo

import com.google.gson.GsonBuilder
import com.gvalencia.restaurantesapp.domain.WebService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    val webservice by lazy {
        Retrofit.Builder()
            .baseUrl("http://demo4926626.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}