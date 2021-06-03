package com.example.kotlincountrylist.service

import com.example.kotlincountrylist.model.Country
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryApi {
    @GET("/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries(): Call<ArrayList<Country>>
}

