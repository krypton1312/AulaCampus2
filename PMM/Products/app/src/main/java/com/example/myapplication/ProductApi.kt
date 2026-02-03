package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    suspend fun getAllProducts(): List<ProductResponse>
}