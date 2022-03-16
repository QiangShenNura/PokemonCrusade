package com.nuralogix.pokemon.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nuralogix.pokemon.R

/**
 * Created by Qiang Shen on 2022/3/16.
 */
data class CraftViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvNum = itemView.findViewById<TextView>(R.id.tv_num)
    val tvName = itemView.findViewById<TextView>(R.id.tv_name)
    val tvId = itemView.findViewById<TextView>(R.id.tv_id)
    val conItem = itemView.findViewById<View>(R.id.cons_item)
}
