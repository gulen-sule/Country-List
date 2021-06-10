package com.example.kotlincountrylist

import android.annotation.SuppressLint//sor
import android.content.ClipData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.view.menu.MenuView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isNotEmpty
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.example.kotlincountrylist.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)//direk setContentView de yapılabilir ama databinding kullandık

        toolbar = binding.myToolbar
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.options -> {
                val fragment = getFragmentFind<CountryFragment>()
                fragment?.let {
                    //it.loadPage()
                    Log.d("fragmentForEachTAG", it.id.toString())
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private inline fun <reified T : Any> getFragmentFind(): T? {
        val navC = supportFragmentManager.findFragmentById(R.id.fragment)
        navC?.childFragmentManager?.fragments?.forEach {
            if (it is T) {
                return it
            }
        }

        return null
    }

}