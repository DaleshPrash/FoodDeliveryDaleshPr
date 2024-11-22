package com.example.fooddeliverydaleshpr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddeliverydaleshpr.model.MenuItem
import javax.inject.Inject
class SharedCartViewModel @Inject constructor() : ViewModel() {
    private val _cartItems = MutableLiveData<List<Pair<MenuItem, Int>>>(emptyList())
    val cartItems: LiveData<List<Pair<MenuItem, Int>>> = _cartItems

    fun addItem(menuItem: MenuItem, quantity: Int) {
        val updatedCart = _cartItems.value?.toMutableList() ?: mutableListOf()
        updatedCart.add(menuItem to quantity)
        _cartItems.value = updatedCart
    }
}
