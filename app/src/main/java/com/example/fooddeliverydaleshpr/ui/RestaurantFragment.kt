package com.example.fooddeliverydaleshpr.ui


// ui/RestaurantFragment.kt

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.fooddeliverydaleshpr.adapter.RestaurantMenuAdapter
import com.example.fooddeliverydaleshpr.databinding.FragmentRestaurantBinding
import com.example.fooddeliverydaleshpr.network.RetrofitInstance
import com.example.fooddeliverydaleshpr.repository.RestaurantRepository
import com.example.fooddeliverydaleshpr.viewmodel.RestaurantViewModel
import com.example.fooddeliverydaleshpr.viewmodel.RestaurantViewModelFactory
import com.example.fooddeliverydaleshpr.viewmodel.SharedCartViewModel

import kotlinx.coroutines.launch

class RestaurantFragment : Fragment() {
    private val sharedCartViewModel: SharedCartViewModel by activityViewModels()
    private var _binding: FragmentRestaurantBinding? = null
    private val binding get() = _binding!!

    private val restaurantViewModel: RestaurantViewModel by viewModels {
        RestaurantViewModelFactory(RestaurantRepository(RetrofitInstance.apiServiceRestaurant))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView
        // Initialize RecyclerView with empty data and onItemClick handling
        val adapter = RestaurantMenuAdapter(emptyList()) { menuItem ->
            // Handle item click: Open MenuItemBottomSheet
            val bottomSheet = MenuItemBottomSheet().apply {
                arguments = Bundle().apply {
                    putParcelable("menuItem", menuItem)
                }
            }
            bottomSheet.show(parentFragmentManager, "MenuItemBottomSheet")
        }
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        restaurantViewModel.fetchRestaurantById("11")

        // Observe the restaurant data and populate the RecyclerView
        viewLifecycleOwner.lifecycleScope.launch {
            // delay(6000)  // Add a small delay between updates
            restaurantViewModel.restaurant.observe(viewLifecycleOwner) { restaurant ->
                if (isAdded && _binding != null) {
                    val menuItems = restaurant.menuCategories.flatMap { it.menuItems }
                    // Update the adapter's data without re-creating it
                    adapter.updateData(menuItems)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
