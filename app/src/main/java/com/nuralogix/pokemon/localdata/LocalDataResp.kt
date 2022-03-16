package com.nuralogix.pokemon.localdata

import com.nuralogix.pokemon.network.PokemonDetail

/**
 * Created by Qiang Shen on 2022/3/16.
 * TODO need to do data persistence
 * temporary just use global static variable to save data
 */
class LocalDataResp {
    companion object{
        var pokemonDetailListLocal: List<PokemonDetail>?= null
        const val KEY_LOCAL_SPACE_LIST_DATA = "KEY_LOCAL_SPACE_LIST_DATA";
        const val KEY_LOCAL_POKEMON_LIST_DATA = "KEY_LOCAL_POKEMON_LIST_DATA";
        fun saveLocalSpaceListData() {

        }

        fun saveLocalPokemonListData() {

        }

        fun getLocalSpaceListData(): Any {
            return Any()
        }

        fun getLocalPokemonListData(): Any {
            return Any()
        }
    }

}