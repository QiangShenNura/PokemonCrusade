package com.nuralogix.pokemon.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nuralogix.pokemon.base.BaseViewModel
import com.nuralogix.pokemon.localdata.LocalDataResp.Companion.pokemonDetailListLocal
import com.nuralogix.pokemon.network.PokemonDetail
import com.nuralogix.pokemon.network.RetrofitFactory
import kotlinx.coroutines.launch

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class DetailViewModel : BaseViewModel() {
    var pokemonDetailList = MutableLiveData<List<PokemonDetail>>()

    fun getPokemonDetail() {
        viewModelScope.launch {
            if (pokemonDetailListLocal.isNullOrEmpty()) {
                val pokemonDetailResponse = RetrofitFactory.instance.service.getPokemonDetailList()
                System.err.println("pokemonDetailResponse=${pokemonDetailResponse}")
                pokemonDetailList.value = pokemonDetailResponse.pokemon
                pokemonDetailListLocal = pokemonDetailResponse.pokemon
            } else{
                pokemonDetailList.value = pokemonDetailListLocal
            }
        }
    }

}