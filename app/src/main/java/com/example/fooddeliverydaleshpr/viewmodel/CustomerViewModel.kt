package com.example.fooddeliverydaleshpr.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddeliverydaleshpr.model.Customer
import com.example.fooddeliverydaleshpr.repository.CustomerRepository
import kotlinx.coroutines.launch

class CustomerViewModel(private val repository: CustomerRepository) : ViewModel() {

    // LiveData for all customers
    private val _customers = MutableLiveData<List<Customer>>()
    val customers: LiveData<List<Customer>> get() = _customers

    // LiveData for a single customer
    private val _customer = MutableLiveData<Customer>()
    val customer: LiveData<Customer> get() = _customer

    // LiveData for operation success/failure (like create, update, delete)
    private val _operationStatus = MutableLiveData<Boolean>()
    val operationStatus: LiveData<Boolean> get() = _operationStatus

    // Fetch all customers
    fun fetchAllCustomers() {
        viewModelScope.launch {
            val response = repository.getAllCustomers()
            if (response.isSuccessful) {
                _customers.postValue(response.body())
            } else {
                _customers.postValue(emptyList())
            }
        }
    }

    // Fetch a specific customer by ID
    fun fetchCustomerById(id: String) {
        viewModelScope.launch {
            val response = repository.getCustomerById(id)
            if (response.isSuccessful) {
                _customer.postValue(response.body())
            }
        }
    }

    // Create a new customer
    fun createCustomer(customer: Customer) {
        viewModelScope.launch {
            val response = repository.createCustomer(customer)
            _operationStatus.postValue(response.isSuccessful)
        }
    }

    // Update an existing customer
    fun updateCustomer(id: String, customer: Customer) {
        viewModelScope.launch {
            val response = repository.updateCustomer(id, customer)
            _operationStatus.postValue(response.isSuccessful)
        }
    }

    // Delete a customer by ID
    fun deleteCustomer(id: String) {
        viewModelScope.launch {
            val response = repository.deleteCustomer(id)
            _operationStatus.postValue(response.isSuccessful)
        }
    }
}
