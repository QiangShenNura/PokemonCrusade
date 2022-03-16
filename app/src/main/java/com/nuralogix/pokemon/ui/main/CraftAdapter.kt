package com.nuralogix.pokemon.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.ColorUtils
import com.nuralogix.pokemon.R
import com.nuralogix.pokemon.network.Space
import com.nuralogix.pokemon.ui.CraftViewHolder
import kotlin.random.Random

/**
 * Created by Qiang Shen on 2022/3/16.
 */
class CraftAdapter(val itemClickListener:View.OnClickListener) : RecyclerView.Adapter<CraftViewHolder>() {
    private var dataList: List<Space>? = null
    fun setData(dataList: MutableList<Space>?) {
        this.dataList = dataList
        notifyDataSetChanged()
        //todo use DiffUtil to update data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CraftViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pokemon_in_craft, parent, false)
        return CraftViewHolder(view)
    }

    override fun onBindViewHolder(holder: CraftViewHolder, position: Int) {
        val space = dataList?.get(position)
        holder.tvId.text = "id: ${space?.id}"
        holder.tvName.text = "name: ${space?.name}"
        holder.tvNum.text = "num: ${space?.num}"
        //set random color
        holder.conItem.setBackgroundColor(ColorUtils.getRandomColor())
        holder.conItem.setOnClickListener {
            it.tag = space?.id
            itemClickListener.onClick(it)
        }
    }

    override fun getItemCount(): Int {
        return dataList?.size?:0
    }


}