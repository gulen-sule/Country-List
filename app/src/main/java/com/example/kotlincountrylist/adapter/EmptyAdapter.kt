package com.example.kotlincountrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.ItemEmptyBinding
import java.util.*

class EmptyAdapter(emptyList: List<String?>) : RecyclerView.Adapter<EmptyAdapter.ViewHolder>() {

    private var emptyList: List<String?> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val emptyBinding: ItemEmptyBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_empty, parent, false)
        return ViewHolder(emptyBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.eventsBinding.textView.text="Set text"
    }

    override fun getItemCount(): Int {
        return emptyList.size
    }

    inner class ViewHolder(itemView:ItemEmptyBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var eventsBinding: ItemEmptyBinding = itemView
    }

    init {
        this.emptyList = emptyList
    }
}