package com.nuralogix.pokemon.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nuralogix.pokemon.network.Space

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class MyFragmentPageAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    var mSpaceData: List<MutableList<Space>>? = null

    fun setData(spaceData: HashMap<String, MutableList<Space>>) {
        if (spaceData.isNullOrEmpty()) {
            return
        }
        this.mSpaceData = spaceData.values.toList()
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return PokemonCraftFragment(mSpaceData?.get(position))
    }

    override fun getCount(): Int {
        return mSpaceData?.size?:0
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mSpaceData?.get(position)?.get(0)?.craft
    }
}