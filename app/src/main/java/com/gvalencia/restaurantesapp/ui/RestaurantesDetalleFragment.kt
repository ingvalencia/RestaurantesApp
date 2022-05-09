package com.gvalencia.restaurantesapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.gvalencia.restaurantesapp.R
import com.gvalencia.restaurantesapp.data.model.Restaurante
import kotlinx.android.synthetic.main.fragment_restaurantes_detalle.*

class RestaurantesDetalleFragment : Fragment() {

    private  lateinit var Restaurante:Restaurante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            Restaurante = it.getParcelable("Restaurante")!!
            Log.d("Detalles","${Restaurante.toString()}")
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_restaurantes_detalle, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(Restaurante.imagen).into(img_restaurantedetalle)
        restaurante_nombre.text = Restaurante.nombre
        restaurante_descripcion.text = Restaurante.descripcion
        restaurante_anio.text = Restaurante.anio
        restaurante_costo.text = Restaurante.costo
        restaurante_reseña.text = Restaurante.reseña
        restaurante_direccion.text = Restaurante.direccion

    }


}