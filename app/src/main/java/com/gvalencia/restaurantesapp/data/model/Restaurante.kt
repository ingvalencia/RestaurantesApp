package com.gvalencia.restaurantesapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Restaurante(


    @SerializedName("imagen_logo")
    val imagen:String="",
    @SerializedName("nombre")
    val nombre:String="",
    @SerializedName("calificacion")
    val descripcion:String="",
    @SerializedName("año")
    val anio:String="",
    @SerializedName("costo_promedio")
    val costo:String="",
    @SerializedName("reseña")
    val reseña:String="",
    @SerializedName("direccion")
    val direccion:String="",
    @SerializedName("imagen_A")
    val imagen_A:String="",
    @SerializedName("imagen_B")
    val imagen_B:String="",
    @SerializedName("imagen_C")
    val imagen_C:String="",



):Parcelable

data class RestauranteList(
    @SerializedName("Restaurante")
    val restauranteList:List<Restaurante> )