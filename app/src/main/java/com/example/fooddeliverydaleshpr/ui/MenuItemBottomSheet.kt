package com.example.fooddeliverydaleshpr.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fooddeliverydaleshpr.databinding.FragmentMenuItemProfileBinding
import com.example.fooddeliverydaleshpr.model.MenuItem
import com.example.fooddeliverydaleshpr.viewmodel.SharedCartViewModel

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuItemBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentMenuItemProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var menuItem: MenuItem
    private var quantity = 1

    private val sharedCartViewModel: SharedCartViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuItemProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the passed MenuItem from arguments
        menuItem = requireArguments().getParcelable("menuItem")!!

        // Populate the UI
        binding.textViewItemName.text = menuItem.name
        binding.textViewItemPrice.text = "₹${menuItem.price}"
        updateQuantityUI()

        // Handle button clicks
        binding.buttonIncrease.setOnClickListener {
            quantity++
            updateQuantityUI()
        }

        binding.buttonDecrease.setOnClickListener {
            if (quantity > 1) quantity--
            updateQuantityUI()
        }
        handleClickEvents()

        binding.buttonAddToCart.setOnClickListener {
            // Add item to the shared ViewModel cart
            sharedCartViewModel.addItem(menuItem, quantity)
            dismiss() // Close the bottom sheet
        }
        //  parentFragmentManager.setFragmentResult("addToCart", result)
        // dismiss()
    }

    private fun updateQuantityUI() {
        binding.textViewQuantity.text = "Quantity: $quantity"
        binding.textViewTotalPrice.text = "Total: ₹${menuItem.price * quantity}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun handleClickEvents() {
        binding.buttonIncrease.setOnClickListener {
            quantity++
            updateQuantityUI()
        }

        binding.buttonDecrease.setOnClickListener {
            if (quantity > 1) quantity--
            updateQuantityUI()
        }
    }
}
