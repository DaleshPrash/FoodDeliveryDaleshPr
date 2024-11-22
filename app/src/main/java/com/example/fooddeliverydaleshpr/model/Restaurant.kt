package com.example.fooddeliverydaleshpr.model

// model/Restaurant.kt

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val id: String,
    val name: String,
    val cuisineType: String,
    val menuCategories: List<MenuCategory>
) : Parcelable

@Parcelize
data class MenuCategory(
    val name: String,
    val menuItems: List<MenuItem>
) : Parcelable

@Parcelize
data class MenuItem(
    val id: String,
    val name: String,
    val price: Double
) : Parcelable
