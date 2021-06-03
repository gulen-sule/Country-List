package com.example.kotlincountrylist.service

import com.example.kotlincountrylist.model.Country
import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIService {
    private val BASE_URL = "https://raw.githubusercontent.com"
    /*private val api =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(CountryApi::class.java)
    fun getData(): Response<ResponseBody> {
        return api.getCountries()
    }*/
}