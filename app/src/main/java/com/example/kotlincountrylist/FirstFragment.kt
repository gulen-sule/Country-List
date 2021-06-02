package com.example.kotlincountrylist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincountrylist.adapter.FirstAdapter
import com.example.kotlincountrylist.model.Model
import com.example.kotlincountrylist.viewmodel.FirstViewModel


class FirstFragment : Fragment() {
    private lateinit var viewModel: FirstViewModel
    private lateinit var myList: ArrayList<Model>
    private lateinit var recycler: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorMessage: TextView




    val country = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country2 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country3 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")

    val country4 = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country5 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country6 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")

    val country7 = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country28 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    val country37 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(FirstViewModel::class.java)
        viewModel.refreshData()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//
//
//        val country = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country2 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country3 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//
//        val country4 = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country5 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country6 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//
//        val country7 = Model("Turkey", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country28 = Model("German", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")
//        val country37 = Model("US", "Asia", "Ankara", "TRY", "www.ss.com", "Turkish")

        myList = arrayListOf(
            country,
            country2,
            country3,
            country28,
            country4,
            country6,
            country5,
            country7,
            country37
        )
        recycler = view.findViewById(R.id.countryList)
        progressBar=view.findViewById(R.id.Countryloading)
        errorMessage=view.findViewById(R.id.countryError)
        requireActivity().runOnUiThread {//bunsuz da calisiyor ne ise yaradigini tam anlamadım
            val adapter = FirstAdapter(myList)
            recycler.adapter = adapter
        }
        progressBar.visibility = View.INVISIBLE
        errorMessage.visibility=View.INVISIBLE

    }


}