package com.example.kotlincountrylist.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlincountrylist.FirstFragment
import com.example.kotlincountrylist.FirstFragmentDirections
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.FragmentCountryBinding
import com.example.kotlincountrylist.databinding.FragmentFirstBinding
import com.example.kotlincountrylist.databinding.ItemSecBinding
import com.example.kotlincountrylist.model.Country
import com.example.kotlincountrylist.model.Model
import com.squareup.picasso.Picasso

class FirstAdapter(modelList: List<Country>, val onClick: (county: Country) -> Unit)//onClick yine ust sinifa bildirim gondermek icin
    : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>(), ItemClickListener {

    private var modelList: List<Country> = modelList//inite gerek kalmiyor

    class FirstViewHolder(binding: ItemSecBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemBinding: ItemSecBinding = binding//class elemani olarak tanımladım
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        //val inflater=LayoutInflater.from(parent.context) art,ik data binding ile inflate yapilacak
        val binding: ItemSecBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_sec,
            parent,
            false
        )
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        val context = holder.itemView.context
        val country = modelList[position]

        holder.itemBinding.data = country//data bindinge ile verimi attim artik
//        Glide.with(context).load(country.countryFlag).skipMemoryCache(true)
//            .into(holder.itemBinding.flagIV)//resimleri yuklemek icin glide veya picasso kutuphanesi
        Picasso.get().load(country.countryFlag).into(holder.itemBinding.flagIV)

        holder.itemBinding.itemLinear.setOnClickListener {
            onClick(country)
        }
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onItemClick(view: View) {
        super.onItemClick(view)
    }
}