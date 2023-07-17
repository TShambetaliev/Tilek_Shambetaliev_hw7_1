package com.example.tilek_shambetaliev_hw7_1.di

import android.content.Context
import androidx.room.Room
import com.example.tilek_shambetaliev_hw7_1.data.local.VideoDao
import com.example.tilek_shambetaliev_hw7_1.data.local.VideoDataBase
import com.example.tilek_shambetaliev_hw7_1.data.repositories.VideoRepositoryImpl
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object VideoModule {

    @Singleton
    @Provides
    fun provideFamilyDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context = context,
        VideoDataBase::class.java,
        "contact_db"
    )

    @Provides
    fun provideFamilyDao(videoDataBase: VideoDataBase) = videoDataBase.videoDao()

    @Provides
    fun provideFamilyRepository(videoDao: VideoDao): VideoRepository {
        return VideoRepositoryImpl(videoDao = videoDao)
    }
}