
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


<img width="348" alt="Screenshot 2024-11-22 at 4 42 04 PM" src="https://github.com/user-attachments/assets/c10b02f0-9af3-490b-a3b6-9681e729ee0b">
<img width="506" alt="Screenshot 2024-11-22 at 4 27 20 PM" src="https://github.com/user-attachments/assets/53d9f252-5809-4c82-9dde-16970ed61fd7">
<img width="498" alt="Screenshot 2024-11-22 at 4 27 06 PM" src="https://github.com/user-attachments/assets/93fefe07-4eae-4118-ae3c-3093609f388e">
<img width="532" alt="Screenshot 2024-11-22 at 4 20 20 PM" src="https://github.com/user-attachments/assets/4d034ac4-e8d0-4c15-a298-be78f1f8425b">


<img width="1920" alt="Screenshot 2024-11-22 at 5 08 10 PM" src="https://github.com/user-attachments/assets/d86e1a17-41c3-45df-8891-2eb5884a349e">
<img width="1336" alt="Screenshot 2024-11-22 at 5 08 01 PM" src="https://github.com/user-attachments/assets/5b104b93-55d9-40c2-b396-496a6f235ddc">

