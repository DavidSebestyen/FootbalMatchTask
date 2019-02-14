package com.matchcenter.davidsebestyen.matchcenter.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.data.Player
import com.matchcenter.davidsebestyen.matchcenter.databinding.ItemPlayerBinding
import java.text.FieldPosition

class PlayerAdapter(val context: Context, val playerList: List<Player>): RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val binding = DataBindingUtil.inflate<ItemPlayerBinding>(LayoutInflater.from(context), R.layout.item_player, p0, false)

        return ViewHolder(binding, playerList)
    }

    override fun getItemCount(): Int {
       return playerList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(position)
    }

    class ViewHolder(val binding: ItemPlayerBinding, val playerList: List<Player>): RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){
            binding.player = playerList[position]
        }
    }
}