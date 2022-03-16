package com.nuralogix.pokemon

import android.util.Log
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nuralogix.pokemon.network.RetrofitFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Qiang Shen on 2022/3/17.
 */
@RunWith(AndroidJUnit4::class)
class ResponsesTest {
    @Test
    fun getPokemonInSpaceList() {
        MainScope().launch {
            val response = RetrofitFactory.instance.service.getPokemonInSpaceList()
            assert(response.space.isNotEmpty())
            assert(response.space[0].craft.isNotEmpty())
            assert(response.space[0].name.isNotEmpty())
            assert(response.space[0].num.isNotEmpty())
            assert(response.space[0].id > 0)
        }
    }

    @Test
    fun getPokemonDetailList() {
        MainScope().launch {
            val response = RetrofitFactory.instance.service.getPokemonDetailList()
            assert(response.pokemon.isNotEmpty())
            assert(response.pokemon[0].img.isNotEmpty())
            assert(response.pokemon[0].name.isNotEmpty())
            assert(response.pokemon[0].id > 0)
            assert(response.pokemon[0].weight.isNotEmpty())
            assert(response.pokemon[0].height.isNotEmpty())
            assert(response.pokemon[0].weaknesses.isNotEmpty())
            assert(response.pokemon[0].type.isNotEmpty())
        }
    }
}