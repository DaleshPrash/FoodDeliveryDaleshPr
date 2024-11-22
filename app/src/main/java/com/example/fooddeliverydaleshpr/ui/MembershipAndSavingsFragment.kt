package com.example.fooddeliverydaleshpr.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fooddeliverydaleshpr.databinding.FragmentMembershipAndSavingsBinding

class MembershipAndSavingsFragment : Fragment() {
    private var _binding: FragmentMembershipAndSavingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMembershipAndSavingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Example data (Replace with real data later)
        binding.textViewCurrentMembership.text = "Current Membership: Gold"
        binding.textViewSwitchMembership.text = "Switch to: Platinum"
        binding.textViewSavings.text = "Savings: ₹500/month"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
