package com.nuralogix.pokemon.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.nuralogix.pokemon.R
import com.nuralogix.pokemon.databinding.ActivityPokemonDetailBinding
import com.nuralogix.pokemon.ext.Constants
import com.nuralogix.pokemon.network.PokemonDetail

/**
 * pokemon detail page
 * display attribute and image of pokemon
 */
class PokemonDetailActivity : AppCompatActivity() {
    private var pokemonId: Int = 0
    private lateinit var binding:ActivityPokemonDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pokemonId = intent.getIntExtra(Constants.KEY_EXTRA_ID,0)

        viewModel.run {
            pokemonDetailList.observe(this@PokemonDetailActivity){
                setDetail(it)
            }
        }
        //TODO loading when start fetch data, stop loading when fetch over
        viewModel.getPokemonDetail()
    }

     //set data to UI
    private fun setDetail(detailList: List<PokemonDetail>?) {
        if (detailList != null) {
            var select:PokemonDetail ?= null
            for (pokemon in detailList) {
                if (pokemonId == pokemon.id) {
                    select = pokemon
                    break
                }
            }
            binding.tvDetailName.text = select?.name
            Glide.with(this)
                .load(select?.img)
                .placeholder(R.mipmap.ic_launcher)
                .into(binding.ivDetailImg)
            binding.tvDetailHeight.text = "Height: ${select?.height}"
            binding.tvDetailWeight.text = "Weight: ${select?.weight}"
            binding.tvDetailType.text = "Type: ${select?.type.toString()}"
            binding.tvDetailWeaknesses.text = "Weaknesses: ${select?.weaknesses.toString()}"
        }

    }


}