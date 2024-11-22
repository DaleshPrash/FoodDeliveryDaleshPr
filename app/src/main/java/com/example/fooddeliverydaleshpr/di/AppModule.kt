package com.example.fooddeliverydaleshpr.di

import android.content.Context
import androidx.room.Room
import com.example.fooddeliverydaleshpr.dao.AppDatabase
import com.example.fooddeliverydaleshpr.dao.CustomerMembershipDao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// NOT functional yet
// Hilt-specific imports
import dagger.hilt.android.qualifiers.ApplicationContext
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide Room Database
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "customer_database"
        ).build()
    }

    // Provide DAO
    @Provides
    fun provideCustomerMembershipDao(database: AppDatabase): CustomerMembershipDao {
        return database.customerMembershipDao()
    }

    // Provide Retrofit instance
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://your-api-url.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide API Service
}

/*
class MembershipRepository @Inject constructor(
    private val dao: CustomerMembershipDao,
    private val apiService: ApiService
) {

    suspend fun getMembership(customerId: String): CustomerMembershipEntity? {
        return dao.getMembership(customerId)
    }

    suspend fun updateMembership(customerId: String, membershipType: String) {
        dao.updateMembership(customerId, membershipType)
    }

    suspend fun insertOrUpdateMembership(membership: CustomerMembershipEntity) {
        dao.insertOrUpdateMembership(membership)
    }
}
 */
