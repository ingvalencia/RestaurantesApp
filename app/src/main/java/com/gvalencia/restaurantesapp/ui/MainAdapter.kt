package com.gvalencia.restaurantesapp.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gvalencia.restaurantesapp.R
import com.gvalencia.restaurantesapp.base.BaseViewHolder
import com.gvalencia.restaurantesapp.data.model.Restaurante
import kotlinx.android.synthetic.main.restaurantes_row.view.*

class MainAdapter(private val context: Context, private val restaurantesList: List<Restaurante>,
private val itemClickListener:OnRestauranteClickListener): RecyclerView.Adapter<BaseViewHolder<*>>(){

    interface OnRestauranteClickListener{
        fun onRestauranteClick(Restaurante: Restaurante)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.restaurantes_row,parent,false))
    }

    override fun getItemCount(): Int {
        return restaurantesList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is MainViewHolder -> holder.bind(restaurantesList[position],position)
        }
    }

    inner class MainViewHolder(itemView: View): BaseViewHolder<Restaurante>(itemView){
        override fun bind(item: Restaurante, position: Int) {

            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_restaurante)
            itemView.text_titulo.text = item.nombre
            itemView.text_descripcion.text = item.descripcion
            itemView.text_anio.text = item.anio
            itemView.text_costo.text = item.costo
            itemView.setOnClickListener { itemClickListener.onRestauranteClick(item) }




        }

    }


}