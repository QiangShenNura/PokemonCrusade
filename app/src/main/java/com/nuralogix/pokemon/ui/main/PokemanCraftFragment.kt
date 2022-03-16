package com.nuralogix.pokemon.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.blankj.utilcode.util.ToastUtils
import com.nuralogix.pokemon.databinding.PokemonCraftFragmentBinding
import com.nuralogix.pokemon.ext.Constants
import com.nuralogix.pokemon.network.Space
import com.nuralogix.pokemon.ui.detail.PokemonDetailActivity

class PokemonCraftFragment(var pokemonInCraftList: MutableList<Space>?) : Fragment() {
    private lateinit var binding: PokemonCraftFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = PokemonCraftFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val mAdapter = CraftAdapter {
            //item click event !
            goToPokemonDetail(it.tag as Int)
        }
        binding.recycleView.adapter = mAdapter
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        // we need sort list by num before assemble data
        pokemonInCraftList?.sortBy {
            it.num
        }
        mAdapter.setData(pokemonInCraftList)
    }

    private fun goToPokemonDetail(pokemonId: Int) {
        ToastUtils.showShort("click pokemonId=${pokemonId}")
        //TODO to prevent quick click
        startActivity(Intent(activity,PokemonDetailActivity::class.java).apply {
            putExtra(Constants.KEY_EXTRA_ID,pokemonId)
        })
    }
}