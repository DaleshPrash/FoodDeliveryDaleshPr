package com.example.fooddeliverydaleshpr.ui
/* SOLE purspose for DAO and usage
@AndroidEntryPoint
class MembershipFragment : Fragment() {

    private val viewModel: MembershipViewModel by viewModels {
        val dao = App.database.customerMembershipDao()
        MembershipRepository(dao)
    }

    private lateinit var binding: FragmentMembershipAndSavingsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMembershipAndSavingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get and display the membership type
        viewModel.getMembership("customer_123") { membership ->
            if (membership != null) {
                binding.textViewCurrentMembership.text = "Current: ${membership.membershipType}"
            } else {
                binding.textViewCurrentMembership.text = "No Membership Found"
            }
        }

        // Handle Switch Membership button click
        binding.switchMembershipButton.setOnClickListener {
            val newType = "Platinum" // Example value
            viewModel.updateMembership("customer_123", newType)
            Toast.makeText(requireContext(), "Membership Updated", Toast.LENGTH_SHORT).show()
        }
    }
}

 */
