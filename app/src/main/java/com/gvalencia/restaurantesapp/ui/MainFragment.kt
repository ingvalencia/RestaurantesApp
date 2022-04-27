package com.gvalencia.restaurantesapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
//import com.bumptech.glide.load.engine.Resource
import com.gvalencia.restaurantesapp.vo.Resource
import com.gvalencia.restaurantesapp.R
import com.gvalencia.restaurantesapp.data.model.DataSource
import com.gvalencia.restaurantesapp.data.model.Restaurante
import com.gvalencia.restaurantesapp.domain.RepoImpl
import com.gvalencia.restaurantesapp.ui.viewmodel.MainViewModel
import com.gvalencia.restaurantesapp.ui.viewmodel.VMFactory
import kotlinx.android.synthetic.main.fragment_main.*



class MainFragment : Fragment(),MainAdapter.OnRestauranteClickListener {

    private val viewModel by viewModels<MainViewModel>{
        VMFactory(RepoImpl(DataSource()))
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.fetchRestauranteList.observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Resource.Loading-> {
                    //progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    //progressBar.visibility = View.GONE
                    rv_restaurantes.adapter= MainAdapter(requireContext(),result.data, this)

                }
                is Resource.Failure -> {
                    //progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Ocurrio un error al traer los datos ${result.exception}", Toast.LENGTH_LONG).show()

                }

            }
        })

    }

    override fun onRestauranteClick(Restaurante: Restaurante) {

        val bundle = Bundle()
        bundle.putParcelable("Restaurante",Restaurante)
        findNavController().navigate(R.id.action_mainFragment_to_restaurantesDetalleFragment2,bundle)
    }

    private fun setupRecyclerView(){
        rv_restaurantes.layoutManager = LinearLayoutManager(requireContext())
        rv_restaurantes.addItemDecoration(DividerItemDecoration(requireContext(),DividerItemDecoration.VERTICAL))
    }




}