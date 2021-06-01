package com.example.kotlincountrylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.FragmentFirstBinding
import com.example.kotlincountrylist.model.Model

class FirstAdapter(val liste:ArrayList<Model>) :
    RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() {
    private var myList:ArrayList<Model>?=null

    class FirstViewHolder (val binding:FragmentFirstBinding): RecyclerView.ViewHolder(binding.root) {
        var eventBinding:FragmentFirstBinding=binding//class elemani olarak tanımladım

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstAdapter.FirstViewHolder {
       val binding:FragmentFirstBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.fragment_first,parent,false)
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstAdapter.FirstViewHolder, position: Int) {
       val event=holder.eventBinding
        event.countryError.visibility=View.INVISIBLE
        event.Countryloading.visibility=View.INVISIBLE
        event.countryList
    }

    override fun getItemCount(): Int {
        return liste.size
    }


}