package com.nuralogix.pokemon.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nuralogix.pokemon.R
import com.nuralogix.pokemon.databinding.ActivityMainBinding

/**
 * main page display pokeman list in the craft
 */
class MainActivity : AppCompatActivity() {
    private lateinit var fragmentAdapter: MyFragmentPageAdapter
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.title = getString(R.string.pokemon_in_craft)
        initViews()
        mainViewModel.run {
            spaceList?.observe(this@MainActivity){
                fragmentAdapter.setData(it)
            }
        }
        //TODO loading when start fetch data, stop loading when fetch over
        mainViewModel.getPokemonInSpace()
        // test comment
        // test comment 1
        // test comment 2
    }

    private fun initViews() {
        fragmentAdapter = MyFragmentPageAdapter(supportFragmentManager)
        binding.viewPager.adapter = fragmentAdapter
        //TODO
        //if we have lots of craft , we need to change custom a TabLayout
        //for best display!
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}