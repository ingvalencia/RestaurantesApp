package com.gvalencia.restaurantesapp.domain

import com.gvalencia.restaurantesapp.data.model.DataSource
import com.gvalencia.restaurantesapp.data.model.Restaurante
import com.gvalencia.restaurantesapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

   suspend override fun getRestaurantesLista(restaurante:String): Resource<List<Restaurante>> {
        return dataSource.getRestaurante(restaurante)
    }


}