package com.example.fooddeliverydaleshpr.dao

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CustomerMembershipEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun customerMembershipDao(): CustomerMembershipDao
}
