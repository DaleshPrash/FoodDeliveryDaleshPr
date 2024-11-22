package com.example.fooddeliverydaleshpr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliverydaleshpr.model.Restaurant
import com.example.fooddeliverydaleshpr.repository.RestaurantRepository
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: RestaurantRepository) : ViewModel() {

    // LiveData for all restaurants
    private val _restaurants = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> get() = _restaurants

    // LiveData for a specific restaurant
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> get() = _restaurant

    // LiveData for operation status (create, update, delete)
    private val _operationStatus = MutableLiveData<Boolean>()
    val operationStatus: LiveData<Boolean> get() = _operationStatus

    // Fetch all restaurants
    fun fetchAllRestaurants() {
        viewModelScope.launch {
            val response = repository.getAllRestaurants()
            if (response.isSuccessful) {
                _restaurants.postValue(response.body())
            } else {
                _restaurants.postValue(emptyList())
            }
        }
    }

    // Fetch a specific restaurant by ID
    fun fetchRestaurantById(id: String) {
        viewModelScope.launch {
            val response = repository.getRestaurantById(id)
            if (response.isSuccessful) {
                _restaurant.postValue(response.body())
            } else {
                _restaurant.postValue(null)
            }
        }
    }

    // Create a new restaurant
    fun createRestaurant(restaurant: Restaurant) {
        viewModelScope.launch {
            val response = repository.createRestaurant(restaurant)
            _operationStatus.postValue(response.isSuccessful)
        }
    }

    // Update an existing restaurant by ID
    fun updateRestaurant(id: String, restaurant: Restaurant) {
        viewModelScope.launch {
            val response = repository.updateRestaurant(id, restaurant)
            _operationStatus.postValue(response.isSuccessful)
        }
    }

    // Delete a restaurant by ID
    fun deleteRestaurant(id: String) {
        viewModelScope.launch {
            val response = repository.deleteRestaurant(id)
            _operationStatus.postValue(response.isSuccessful)
        }
    }
}
