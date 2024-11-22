package com.example.fooddeliverydaleshpr.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fooddeliverydaleshpr.databinding.FragmentRestaurantCustomerBinding

class RestaurantCustomerFragment : Fragment() {
    private var _binding: FragmentRestaurantCustomerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRestaurantCustomerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example data (Replace with real data later)
        binding.textViewDistance.text = "Distance: 3.0 miles"
        binding.textViewTimeEstimate.text = "Estimated Delivery Time: 24 minutes"
        binding.textViewDriverInfo.text = "Driver: John Doe (5 stars)"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
