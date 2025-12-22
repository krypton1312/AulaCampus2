package com.example.countries

import CountriesAdapter
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var etSearch: TextInputEditText
    private lateinit var progress: CircularProgressIndicator

    private val adapter = CountriesAdapter(emptyList())
    private var allCountries: List<Country> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler)
        etSearch = findViewById(R.id.etSearch)
        progress = findViewById(R.id.progress)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        etSearch.addTextChangedListener { text ->
            val q = text?.toString()?.trim().orEmpty().lowercase()
            val filtered = if (q.isEmpty()) {
                allCountries
            } else {
                allCountries.filter { (it.name.common ?: "").lowercase().contains(q) }
            }
            adapter.update(filtered)
            recycler.scheduleLayoutAnimation()
        }

        loadCountries()
    }

    private fun loadCountries() {
        progress.visibility = View.VISIBLE

        RetrofitClient.api.getAllCountries().enqueue(object : Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                progress.visibility = View.GONE

                if (!response.isSuccessful) {
                    Toast.makeText(
                        this@MainActivity,
                        "HTTP ${response.code()}",
                        Toast.LENGTH_SHORT
                    ).show()
                    return
                }

                allCountries = (response.body() ?: emptyList())
                    .sortedBy { it.name.common ?: "" }

                adapter.update(allCountries)
            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                progress.visibility = View.GONE
                Toast.makeText(
                    this@MainActivity,
                    "Error: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
