package com.example.fooddeliverydaleshpr.repository


import com.example.fooddeliverydaleshpr.model.Restaurant
import com.example.fooddeliverydaleshpr.network.RestaurantApiService
import retrofit2.Response

class RestaurantRepository(private val apiServiceRestaurant: RestaurantApiService) {

    // Create a new restaurant
    suspend fun createRestaurant(restaurant: Restaurant): Response<Restaurant> {
        return apiServiceRestaurant.createRestaurant(restaurant)
    }

    // Get all restaurants
    suspend fun getAllRestaurants(): Response<List<Restaurant>> {
        return apiServiceRestaurant.getAllRestaurants()
    }

    // Get a specific restaurant by ID
    suspend fun getRestaurantById(id: String): Response<Restaurant> {
        return apiServiceRestaurant.getRestaurantById(id)
    }

    // Update an existing restaurant by ID
    suspend fun updateRestaurant(id: String, restaurant: Restaurant): Response<Restaurant> {
        return apiServiceRestaurant.updateRestaurant(id, restaurant)
    }

    // Delete a restaurant by ID
    suspend fun deleteRestaurant(id: String): Response<Void> {
        return apiServiceRestaurant.deleteRestaurant(id)
    }
}
