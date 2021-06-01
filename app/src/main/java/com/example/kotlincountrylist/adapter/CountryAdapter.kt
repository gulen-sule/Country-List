package com.example.kotlincountrylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.FragmentCountryBinding
import com.example.kotlincountrylist.model.Model

class CountryAdapter(val List:ArrayList<Model>):
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    private var countryList:  ArrayList<Model> = ArrayList<Model>()

    class CountryViewHolder(binding: FragmentCountryBinding) : RecyclerView.ViewHolder(binding.root){
        var eventBinding:FragmentCountryBinding=binding

    }
    init {
        this.countryList=List
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryAdapter.CountryViewHolder {
    val binding:FragmentCountryBinding=DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.fragment_country,parent,false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder:CountryViewHolder, position: Int) {
        holder.eventBinding.Capital.text=countryList[position].capital
        holder.eventBinding.Currency.text=countryList[position].currency
        holder.eventBinding.Language.text=countryList[position].language
        holder.eventBinding.countryName.text=countryList[position].countryName
        holder.eventBinding.countryRegion.text=countryList[position].region

    }

    override fun getItemCount(): Int {
        return List.size
    }


}