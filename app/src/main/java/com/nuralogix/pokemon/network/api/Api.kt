package com.nuralogix.pokemon.network.api

import com.nuralogix.pokemon.network.PokemonDataListBean
import com.nuralogix.pokemon.network.SpaceDataListBean
import retrofit2.http.GET
import retrofit2.http.Headers

/**
 * Created by Qiang Shen on 2022/3/16.
 */
interface Api {
    companion object{
        const val LIST_BASE_URL = "https://gist.githubusercontent.com"
        const val DETAIL_BASE_URL = "https://raw.githubusercontent.com"
        const val POKEMON_IN_SPACE_LIST = "/kamalh16/45b2fd26a8657f9bd97222b74bdce6ec/raw/c11831409641729a2da5347522ff7eff00ae2d0e/pokemon_in_space.json"
        const val POKEMON_DETAIL_LIST = "/Biuni/PokemonGO-Pokedex/master/pokedex.json"
    }

    /**
     * get pokemon in space craft
     */
    @Headers("urlname:space_list")
    @GET(POKEMON_IN_SPACE_LIST)
    suspend fun getPokemonInSpaceList(): SpaceDataListBean

    /**
     * get pokemon in space craft
     */
    @Headers("urlname:detail_list")
    @GET(POKEMON_DETAIL_LIST)
    suspend fun getPokemonDetailList(): PokemonDataListBean

}