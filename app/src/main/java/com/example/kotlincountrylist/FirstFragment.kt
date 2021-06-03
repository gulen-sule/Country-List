package com.example.kotlincountrylist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.adapter.FirstAdapter
import com.example.kotlincountrylist.model.Country
import com.example.kotlincountrylist.model.Model
import com.example.kotlincountrylist.service.CountryApi
import com.example.kotlincountrylist.viewmodel.FirstViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FirstFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel

    //  private lateinit var myList: ArrayList<Model>
    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorMessage: TextView
    private lateinit var countries: ArrayList<Country>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        viewModel.refreshData()

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCountries(completed = {

            // myList = arrayListOf(country, country2, country3, country28, country4, country6, country5, country7, country37)
            recycler = view.findViewById(R.id.countryList)
            progressBar = view.findViewById(R.id.Countryloading)
            errorMessage = view.findViewById(R.id.countryError)

            requireActivity().runOnUiThread {//bunsuz da calisiyor ne ise yaradigini tam anlamadım
                val adapter = FirstAdapter(countries)
                recycler.adapter = adapter
            }

            progressBar.visibility = View.INVISIBLE
            errorMessage.visibility = View.INVISIBLE

        })
    }

    //Bu metot asenksron çalışıyor...
    private fun getCountries(completed: (ArrayList<Country>) -> Unit) {
        val BASE_URL = "https://raw.githubusercontent.com/"
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)

        val response = retrofit.getCountries()

        response.enqueue(object : Callback<ArrayList<Country>> {
            override fun onResponse(call: Call<ArrayList<Country>>, response: Response<ArrayList<Country>>) {
                Log.d("responseSuccess", response.code().toString())
                Log.d("responseSuccess", response.body().toString())
                countries = response.body()!!

                completed(countries)

                //countries[0].countryName
            }

            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }


}