package com.example.kotlincountrylist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.kotlincountrylist.databinding.FragmentCountryBinding
import com.example.kotlincountrylist.model.Country
import com.google.gson.Gson

class CountryFragment : Fragment() {
    private lateinit var dataBinding: FragmentCountryBinding

    var id = "515645"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = arguments?.getSerializable("countryItem") as Country?//ayni bundledan alman gerekiyor veriyi o yuzden arguments

        Log.d("countryModel", Gson().toJson(country))

        dataBinding.data = country
        Glide.with(view.context).load(country!!.countryFlag)
            .into(view.findViewById(R.id.FlagIV2)as ImageView)
        //Picasso.get().load(country.countryFlag).into(holder.itemBinding.flagIV)
    }

}