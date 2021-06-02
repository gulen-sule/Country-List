package com.example.kotlincountrylist.service

import com.example.kotlincountrylist.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {
    @GET("/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Country>>
}