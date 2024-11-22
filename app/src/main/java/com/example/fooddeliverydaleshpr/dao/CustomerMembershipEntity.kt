package com.example.fooddeliverydaleshpr.dao

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_membership")
data class CustomerMembershipEntity(
    @PrimaryKey val customerId: String,
    val membershipType: String
)
