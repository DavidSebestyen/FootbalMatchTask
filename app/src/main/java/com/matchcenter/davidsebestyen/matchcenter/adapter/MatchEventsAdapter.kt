package com.matchcenter.davidsebestyen.matchcenter.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.matchcenter.davidsebestyen.matchcenter.R
import com.matchcenter.davidsebestyen.matchcenter.data.MatchEvent
import com.matchcenter.davidsebestyen.matchcenter.databinding.ItemEventBinding

class MatchEventsAdapter(val context: Context, val eventsList: List<MatchEvent>): RecyclerView.Adapter<MatchEventsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemEventBinding>(LayoutInflater.from(context), R.layout.item_event, p0, false)

        return ViewHolder(binding, eventsList)

    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindData(position)
    }

    class ViewHolder(val binding: ItemEventBinding, val eventsList: List<MatchEvent>): RecyclerView.ViewHolder(binding.root){

        fun bindData(position: Int){
            binding.matchEvent = eventsList[position]
        }


    }
}