package com.example.kotlincountrylist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.FirstFragment
import com.example.kotlincountrylist.FirstFragmentDirections
import com.example.kotlincountrylist.R
import com.example.kotlincountrylist.databinding.FragmentCountryBinding
import com.example.kotlincountrylist.databinding.FragmentFirstBinding
import com.example.kotlincountrylist.databinding.ItemSecBinding
import com.example.kotlincountrylist.model.Model

class FirstAdapter(modelList: ArrayList<Model>) : RecyclerView.Adapter<FirstAdapter.FirstViewHolder>() , ItemClickListener{

    private var modelList: ArrayList<Model> = arrayListOf()

    class FirstViewHolder(binding: ItemSecBinding) : RecyclerView.ViewHolder(binding.root) {
        val itemBinding: ItemSecBinding = binding//class elemani olarak tanımladım

    }

    init {
        this.modelList = modelList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FirstViewHolder {
        //val inflater=LayoutInflater.from(parent.context)
        val binding: ItemSecBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_sec,
            parent,
            false
        )
        return FirstViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.itemBinding.data = modelList[position]
        holder.itemView.setOnClickListener {
            val action=FirstFragmentDirections.actionFirstFragmentToCountryFragment2()
            //FragmentCountryBinding
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onItemClick(view: View) {
        super.onItemClick(view)
        view.setOnClickListener {
        }
    }

}