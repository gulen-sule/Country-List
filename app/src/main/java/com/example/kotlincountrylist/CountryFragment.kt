package com.example.kotlincountrylist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.kotlincountrylist.databinding.FragmentCountryBinding
import com.example.kotlincountrylist.model.Country
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson

class CountryFragment : Fragment(), OnMapReadyCallback {
    private lateinit var dataBinding: FragmentCountryBinding
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_country, container, false)
        dataBinding.mapView.onCreate(savedInstanceState)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val country = arguments?.getSerializable("data") as Country?//ayni bundledan alman gerekiyor veriyi o yuzden argument
        Log.d("countryModel", Gson().toJson(country))

        dataBinding.data = country
        Glide.with(requireContext())
            .load(country?.countryFlag)
            .into(view.findViewById(R.id.FlagIV2) as ImageView)
        dataBinding.mapView.getMapAsync(this)
        //Picasso.get().load(country.countryFlag).into(holder.itemBinding.flagIV)
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.addMarker(MarkerOptions().position(LatLng(139.0, 100.0)).title("this"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(139.0, 100.0), 10.8f))

    }

    override fun onResume() {
        super.onResume()
        dataBinding.mapView.onResume()
    }
    override fun onDestroy() {
        super.onDestroy()
        dataBinding.mapView.onDestroy()
    }
}