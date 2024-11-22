
Title: Feature: Complete Food Delivery Application

This PR includes the implementation of a fully functional Food Delivery Application, aimed at providing a seamless user experience for ordering food online. The project is structured using modern Android development practices such as MVVM architecture, Room database, and Retrofit for API communication. It also incorporates Dependency Injection using Hilt and follows a modular approach for better maintainability and scalability.

Key Features:

	1.	Restaurant Management:
	•	Displays a list of restaurants fetched from an API.
	•	Detailed restaurant information with menu items.
	•	Add menu items to the cart from a restaurant.
	2.	Customer Management:
	•	Customer information is stored and managed in a local Room database.
	•	Membership management for discounts and savings.
	3.	Cart and Checkout:
	•	Dynamic cart to manage selected menu items with quantity adjustments.
	•	Displays total price calculation in real-time.
	•	Place orders via the checkout process.
	4.	UI/UX:
	•	Designed using ConstraintLayout and modern Material Design principles.
	•	User-friendly layout with support for bottom sheets for menu and order details.
	•	Dark mode-ready with theming integration.
	5.	API Integration:
	•	Seamless integration with REST APIs using Retrofit.
	•	Error handling with a robust repository pattern.
	•	Efficient API calls with suspend functions and Kotlin Coroutines.
	6.	Local Storage:
	•	Persistent storage of customer memberships and preferences using Room Database.
	•	Use of DAOs for optimized queries.
	7.	State Management:
	•	Implements a SharedViewModel for cross-fragment communication.
	•	Lifecycle-aware ViewModels to ensure data consistency.

Technical Highlights:

	•	Architecture: MVVM (Model-View-ViewModel) pattern for clean separation of concerns.
	•	Networking: Retrofit with Coroutines for asynchronous API communication.
	//•	Dependency Injection: Hilt for providing dependencies across the application.
	•	Database: Room for local data storage with Entity and DAO pattern.
	•	UI Design: Fragment-based navigation for modular and reusable UI components.

Screenshots:


