package com.example.fooddeliverydaleshpr.model

// model/Customer.kt

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Customer(
    val id: String,
    val name: String,
    val membershipType: String,
    val addresses: List<Address>
) : Parcelable

@Parcelize
data class Address(
    val id: String,
    val street: String,
    val city: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable
