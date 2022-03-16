package com.nuralogix.pokemon.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.nuralogix.pokemon.base.BaseViewModel
import com.nuralogix.pokemon.network.RetrofitFactory
import com.nuralogix.pokemon.network.Space
import com.nuralogix.pokemon.network.SpaceDataListBean
import kotlinx.coroutines.launch

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class MainViewModel :BaseViewModel(){

    var spaceList = MutableLiveData<HashMap<String,MutableList<Space>>>()

    fun getPokemonInSpace()  {
        //viewModelScope will cancel Coroutine when OnCleared method called
        viewModelScope.launch {
            val spaceDataBean = RetrofitFactory.instance.service.getPokemonInSpaceList()
            spaceList.value = sortData(spaceDataBean)
        }
    }

    private fun sortData(spaceDataListBean: SpaceDataListBean):HashMap<String,MutableList<Space>> {
        val dataMap = HashMap<String,MutableList<Space>>()
        //sort by craft type, use craft type for map key, the same craft type data will add to same List
        for (item in spaceDataListBean.space) {
            val craft = item.craft
            if (dataMap.containsKey(craft)){
                dataMap[craft]?.add(item)
            } else {
                val craftList = arrayListOf<Space>()
                craftList.add(item)
                dataMap[craft] = craftList
            }
        }
        return dataMap
    }

}