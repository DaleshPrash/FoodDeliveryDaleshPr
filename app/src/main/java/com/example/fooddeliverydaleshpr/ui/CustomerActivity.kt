package com.example.fooddeliverydaleshpr.ui

import androidx.appcompat.app.AppCompatActivity

class CustomerActivity : AppCompatActivity() {
/*
    private lateinit var viewModel: CustomerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)




        // Create the repository and factory
        val repository = CustomerRepository(RetrofitInstance.apiServiceCustomer)
        val factory = CustomerViewModelFactory(repository)

        // Initialize the ViewModel using the factory
        viewModel = ViewModelProvider(this, factory).get(CustomerViewModel::class.java)



        val customerName = findViewById<EditText>(R.id.editTextCustomerName)
        val membershipType = findViewById<EditText>(R.id.editTextMembershipType)

        val street1 = findViewById<EditText>(R.id.editTextStreet1)
        val city1 = findViewById<EditText>(R.id.editTextCity1)
        val latitude1 = findViewById<EditText>(R.id.editTextLatitude1)
        val longitude1 = findViewById<EditText>(R.id.editTextLongitude1)

        val street2 = findViewById<EditText>(R.id.editTextStreet2)
        val city2 = findViewById<EditText>(R.id.editTextCity2)
        val latitude2 = findViewById<EditText>(R.id.editTextLatitude2)
        val longitude2 = findViewById<EditText>(R.id.editTextLongitude2)

        val submitButton = findViewById<Button>(R.id.btnSubmitCustomer)

        submitButton.setOnClickListener {
            /*val customer = Customer(
                id = "12345",
                name = customerName.text.toString(),
                membershipType = membershipType.text.toString(),
                addresses = listOf(
                    Address(
                        id = "121",
                        street = street1.text.toString(),
                        city = city1.text.toString(),
                        latitude = latitude1.text?.toString()?.toDouble()?:1.1,
                        longitude = longitude1.text?.toString()?.toDouble()?:1.1
                    ),
                    Address(
                        id = "122",
                        street = street2.text.toString(),
                        city = city2.text.toString(),
                        latitude = latitude2.text?.toString()?.toDouble()?:1.1,
                        longitude = longitude2.text?.toString()?.toDouble()?:1.1
                    )
                )
            )

             */

            val customerX = Customer(
                id = "12346",
                name = "John Doe",
                membershipType = "Platinum",
                addresses = listOf(
                    Address(id = "123",street = "456 Oak Avenue", city = "Gotham", latitude = 40.71, longitude = 74.00),
                    Address(id = "111",street = "789 Maple Road", city = "Star City", latitude = 34.05, longitude = 118.24)
                )
            )


          /*  viewModel.createCustomer(customerX) { response ->
                if (response.isSuccessful) {
                    Toast.makeText(this, "Customer created successfully!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to create customer.", Toast.LENGTH_SHORT).show()
                }
            }

           */
        }
    }

 */
}
