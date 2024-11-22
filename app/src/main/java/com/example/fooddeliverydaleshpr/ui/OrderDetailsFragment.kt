package com.example.fooddeliverydaleshpr.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fooddeliverydaleshpr.databinding.FragmentOrderDetailsBinding

class OrderDetailsFragment : Fragment() {
    private var _binding: FragmentOrderDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example data (Replace with ViewModel or real data later)
        binding.textViewOrderItems.text = "1    $200    x1\n2    $100    x2"
        binding.textViewTip.text = "Tip: ₹0.00"
        binding.textViewPaymentMethod.text = "Pay with: Credit Card"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
