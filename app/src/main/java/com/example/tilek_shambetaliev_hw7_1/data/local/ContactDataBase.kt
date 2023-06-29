package com.example.tilek_shambetaliev_hw7_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tilek_shambetaliev_hw7_1.data.models.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDataBase: RoomDatabase() {

    abstract fun contactDao() : ContactDao
}