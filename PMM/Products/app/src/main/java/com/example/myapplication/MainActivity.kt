package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var rvProducts: RecyclerView
    private val adapter = ProductsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProducts = findViewById(R.id.rvProducts)
        rvProducts.layoutManager = LinearLayoutManager(this)
        rvProducts.adapter = adapter

        loadProducts()
    }

    private fun loadProducts() {
        lifecycleScope.launch {
            try {
                val products = ApiClient.productApi.getAllProducts()
                adapter.submitList(products)
            } catch (e: Exception) {
                Log.e("API", "Network error: ${e.message}", e)
            }
        }
    }
}
