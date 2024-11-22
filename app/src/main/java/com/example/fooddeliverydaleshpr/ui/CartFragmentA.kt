package com.example.fooddeliverydaleshpr.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fooddeliverydaleshpr.databinding.FragmentCartABinding
import com.example.fooddeliverydaleshpr.viewmodel.SharedCartViewModel

class CartFragmentA : Fragment() {
    private val sharedCartViewModel: SharedCartViewModel by activityViewModels()
    private var _binding: FragmentCartABinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example data
        val numberOfItems = 3
        val totalPrice = 500.00

        // Update UI
        binding.textViewCartItems.text = "Items: $numberOfItems"
        binding.textViewCartTotal.text = "Total: ₹$totalPrice"

        sharedCartViewModel.cartItems.observe(viewLifecycleOwner) { cartItems ->
            val totalItems = cartItems.sumOf { it.second }
            val totalPrice = cartItems.sumOf { it.first.price * it.second }

            binding.textViewCartItems.text = "Items: $totalItems"
            binding.textViewCartTotal.text = "Total: ₹$totalPrice"

            binding.buttonCheckout.isEnabled = totalItems > 0
        }

        // Handle Checkout button click
        binding.buttonCheckout.setOnClickListener {
            openOrderPlaceActivity()
        }
    }

    private fun openOrderPlaceActivity() {
        val intent = Intent(requireContext(), OrderPlaceActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
