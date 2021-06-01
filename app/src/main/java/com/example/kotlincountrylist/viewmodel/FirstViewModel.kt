package com.example.kotlincountrylist.viewmodel

import android.view.Display
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincountrylist.model.Model

class FirstViewModel :ViewModel(){
    val countries= MutableLiveData<List<Model>>()//mutable ->degistirilebilir
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()
fun refreshData(){
    val country=Model("Turkey","Asia","Ankara","TRY","www.ss.com","Turkish")
    val country2=Model("German","Asia","Ankara","TRY","www.ss.com","Turkish")
    val country3=Model("US","Asia","Ankara","TRY","www.ss.com","Turkish")

    val myList= arrayListOf<Model>(country,country2,country3)
    countries.value=myList
    countryError.value=false
    countryLoading.value=false


}
}