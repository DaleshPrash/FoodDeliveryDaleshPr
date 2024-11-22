package com.example.fooddeliverydaleshpr.repository


import com.example.fooddeliverydaleshpr.model.Customer
import com.example.fooddeliverydaleshpr.network.CustomerApiService
import retrofit2.Response

class CustomerRepository(private val apiServiceCustomer: CustomerApiService) {

    // Create a new customer
    suspend fun createCustomer(customer: Customer): Response<Customer> {
        return apiServiceCustomer.createCustomer(customer)
    }

    // Get all customers
    suspend fun getAllCustomers(): Response<List<Customer>> {
        return apiServiceCustomer.getAllCustomers()
    }

    // Get a specific customer by ID
    suspend fun getCustomerById(id: String): Response<Customer> {
        return apiServiceCustomer.getCustomerById(id)
    }

    // Update a customer by ID
    suspend fun updateCustomer(id: String, customer: Customer): Response<Customer> {
        return apiServiceCustomer.updateCustomer(id, customer)
    }

    // Delete a customer by ID
    suspend fun deleteCustomer(id: String): Response<Void> {
        return apiServiceCustomer.deleteCustomer(id)
    }
}
