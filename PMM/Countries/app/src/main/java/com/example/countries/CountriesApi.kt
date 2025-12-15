package com.example.countries

import retrofit2.Call
import retrofit2.http.GET

interface CountriesApi {
    @GET("v3.1/all?fields=name,capital,region,population,flags,languages,cca2")
    fun getAllCountries(): Call<List<Country>>
}
