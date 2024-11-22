package com.example.fooddeliverydaleshpr.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "http://192.168.1.72:8080/"

    private const val BASE_URLK = "http://localhost:8080/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiServiceCustomer: CustomerApiService by lazy {
        retrofit.create(CustomerApiService::class.java)
    }

    val apiServiceRestaurant: RestaurantApiService by lazy {
        retrofit.create(RestaurantApiService::class.java)
    }
}
