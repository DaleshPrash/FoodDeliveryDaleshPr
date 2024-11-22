package com.example.fooddeliverydaleshpr.network

import com.example.fooddeliverydaleshpr.model.Restaurant
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.POST

interface RestaurantApiService {

    // Create a new restaurant
    @POST("restaurants")
    suspend fun createRestaurant(@Body restaurant: Restaurant): Response<Restaurant>

    // Get all restaurants
    @GET("restaurants")
    suspend fun getAllRestaurants(): Response<List<Restaurant>>

    // Get a specific restaurant by ID
    @GET("restaurants/{id}")
    suspend fun getRestaurantById(@Path("id") id: String): Response<Restaurant>

    // Update an existing restaurant
    @PUT("restaurants/{id}")
    suspend fun updateRestaurant(
        @Path("id") id: String,
        @Body restaurant: Restaurant
    ): Response<Restaurant>

    // Delete a restaurant by ID
    @DELETE("restaurants/{id}")
    suspend fun deleteRestaurant(@Path("id") id: String): Response<Void>
}
