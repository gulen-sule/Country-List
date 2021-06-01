package com.example.kotlincountrylist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountrylist.model.Model

class CountryViewModel:ViewModel() {
    val countryLiveData=MutableLiveData<Model>()
    fun getDataFromRoom(){
        val country=Model("Turkey","Asia","Ankara","TRY","www.ss.com","Turkish")
        countryLiveData.value=country
    }
}