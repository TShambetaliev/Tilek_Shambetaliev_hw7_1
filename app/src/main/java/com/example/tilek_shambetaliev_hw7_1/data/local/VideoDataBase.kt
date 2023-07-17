package com.example.tilek_shambetaliev_hw7_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity

@Database(entities = [VideoEntity::class], version = 1)
abstract class VideoDataBase: RoomDatabase() {

    abstract fun videoDao() : VideoDao
}