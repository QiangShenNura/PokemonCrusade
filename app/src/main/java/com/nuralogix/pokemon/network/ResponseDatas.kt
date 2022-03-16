package com.nuralogix.pokemon.network

/**
 * Created by Qiang Shen on 2022/3/16.
 */

//space craft data
data class SpaceDataListBean (val space: List<Space>)
//pokemon on craft
data class Space(var craft: String,var id:Int,var num: String,var name: String)

//pokemon detail data list
data class PokemonDataListBean(val pokemon: List<PokemonDetail>)

//pokemon detail data
data class PokemonDetail(
    val id: Int,
    val num: String,
    val name: String,
    val img: String,
    val height: String,
    val weight: String,
    val type: List<String>,
    val weaknesses: List<String>,
)
