package com.example.fooddeliverydaleshpr.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fooddeliverydaleshpr.databinding.FragmentCustomerBinding
import com.example.fooddeliverydaleshpr.model.Customer
import com.example.fooddeliverydaleshpr.network.RetrofitInstance
import com.example.fooddeliverydaleshpr.repository.CustomerRepository
import com.example.fooddeliverydaleshpr.viewmodel.CustomerViewModel
import com.example.fooddeliverydaleshpr.viewmodel.CustomerViewModelFactory

class CustomerFragment : Fragment() {

    private var _binding: FragmentCustomerBinding? = null
    private val binding get() = _binding!!

    private val customerViewModel: CustomerViewModel by viewModels {
        CustomerViewModelFactory(CustomerRepository(RetrofitInstance.apiServiceCustomer))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Observe customer data from ViewModel
        customerViewModel.customer.observe(viewLifecycleOwner) { customer ->
            if (isAdded && _binding != null) {
                if (customer != null) {
                    updateUI(customer)
                } else {
                    showError("Failed to load customer data")
                }
            }
        }

        // Show loading state
        binding.progressBar.visibility = View.VISIBLE
        customerViewModel.fetchCustomerById("11") // Replace with actual customer ID
    }

    private fun updateUI(customer: Customer) {
        Log.d("UpdateUI", "Customer Name: ${customer.name}")
        Log.d("UpdateUI", "Customer Address: ${customer.addresses.firstOrNull()?.street}")

        binding.progressBar.visibility = View.GONE

        // Set the text views with customer data
        binding.textViewName.text = "Name: ${customer.name}"
        val address = customer.addresses.firstOrNull()?.street ?: "Unknown Address"
        binding.textViewAddress.text = address
    }

    private fun showError(message: String) {
        binding.progressBar.visibility = View.GONE
        binding.textViewError.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
