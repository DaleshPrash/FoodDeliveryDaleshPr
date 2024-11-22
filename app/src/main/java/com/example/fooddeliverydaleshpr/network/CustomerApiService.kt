package com.example.fooddeliverydaleshpr.network

import com.example.fooddeliverydaleshpr.model.Customer
import retrofit2.Response
import retrofit2.http.*
import retrofit2.http.Body
import retrofit2.http.POST

interface CustomerApiService {

    // Create a new customer
    @POST("customers")
    suspend fun createCustomer(@Body customer: Customer): Response<Customer>

    // Get a list of all customers
    @GET("customers")
    suspend fun getAllCustomers(): Response<List<Customer>>

    // Get a specific customer by ID
    @GET("customers/{id}")
    suspend fun getCustomerById(@Path("id") id: String): Response<Customer>

    // Update a customer by ID
    @PUT("customers/{id}")
    suspend fun updateCustomer(
        @Path("id") id: String,
        @Body customer: Customer
    ): Response<Customer>

    // Delete a customer by ID
    @DELETE("customers/{id}")
    suspend fun deleteCustomer(@Path("id") id: String): Response<Void>
}
