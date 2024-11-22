package com.example.fooddeliverydaleshpr.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fooddeliverydaleshpr.databinding.ActivityOrderPlaceBinding

class OrderPlaceActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderPlaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityOrderPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Load OrderDetailsFragment
        supportFragmentManager.beginTransaction()
            .replace(binding.orderDetailsFragmentContainer.id, OrderDetailsFragment())
            .commit()

        // Load RestaurantCustomerFragment
        supportFragmentManager.beginTransaction()
            .replace(binding.restaurantCustomerFragmentContainer.id, RestaurantCustomerFragment())
            .commit()

        // Load MembershipAndSavingsFragment
        supportFragmentManager.beginTransaction()
            .replace(binding.membershipFragmentContainer.id, MembershipAndSavingsFragment())
            .commit()

        // Handle Place Order button click
        binding.buttonPlaceOrder.setOnClickListener {
            Toast.makeText(this, "Order Placed!", Toast.LENGTH_SHORT).show()
        }
    }
}
