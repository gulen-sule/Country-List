package com.example.kotlincountrylist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
    private lateinit var messagebutton: ImageButton
    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorMessage: TextView
    private lateinit var countries: ArrayList<Country>
    private lateinit var refreshThePage: SwipeRefreshLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        viewModel.refreshData()

        return inflater.inflate(R.layout.fragment_first, container, false)
    }
    private fun loadVariables(view:View){
        recycler = view.findViewById(R.id.countryList)
        progressBar = view.findViewById(R.id.Countryloading)
        errorMessage = view.findViewById(R.id.countryError)
        refreshThePage = view.findViewById(R.id.swipeRefresh)
        messagebutton=view.findViewById(R.id.messageButton)
       // menuItemOptions=view.findViewById(R.id.options)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadVariables(view)
        errorMessage.visibility = View.INVISIBLE
   //     menuItemOptions.setOnMenuItemClickListener()
        loadPage()

        refreshThePage.setOnRefreshListener {
            loadPage()
        }

        messagebutton.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToMailFragment2()
            Navigation.findNavController(requireView()).navigate(action)

            NavHostController(requireContext()).navigateUp()

            //(requireActivity() as MainActivity).binding.fragment.findNavController().navigate()
        }

    }

    //Bu metot asenksron çalışıyor...
    private fun getCountries(completed: (ArrayList<Country>) -> Unit) {//bitip bitmedigini kontrol edebilmek icin completed func
        val BASE_URL = "https://raw.githubusercontent.com/"
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountryApi::class.java)//create'e olusturmasi icin get metodu iceren interface'imi atiyorum

        val response = retrofit.getCountries()

        response.enqueue(object : Callback<ArrayList<Country>> {
            //asenkron calistirabilmek icin coroutines ve suspended function veya bu Callback
            // interface'inden object olusturmak gerekiyor
            override fun onResponse(call: Call<ArrayList<Country>>, response: Response<ArrayList<Country>>) {
                Log.d("responseSuccess", response.code().toString())
                Log.d("responseSuccess", response.body().toString())

                countries = response.body()!!//arraylist<country> donuyor
                completed(countries)//veri cekimi bittiginin bildirimini gonder

            }

            override fun onFailure(call: Call<ArrayList<Country>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun loadPage() {

        getCountries(completed = {
            progressBar.visibility = View.INVISIBLE
            requireActivity().runOnUiThread {//bunsuz da calisiyor ne ise yaradigini tam anlamadım
                val adapter = FirstAdapter(countries, onClick = { country ->//it ->Country
                    val action =
                        FirstFragmentDirections.actionFirstFragmentToCountryFragment2(country)//gondermek istedigim datayi navigaton actionina verdim
                    //cunku navi.xml dosyamda arguman aldigini soyledim
                    Navigation.findNavController(requireView()).navigate(action)

                })
                recycler.adapter = adapter//adapterimi recyclerView'ima ekledim
            }
            refreshThePage.isRefreshing = false
        })

    }


}