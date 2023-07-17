package com.example.tilek_shambetaliev_hw7_1.domain.repositories

import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    suspend fun addVideo(video: Video): Flow<Resource<Unit>>

    suspend fun getVideo(): Flow<Resource<List<Video>>>

    fun getVideoFromLast(): Flow<Resource<List<Video>>>
    fun getVideoSortByName(): Flow<Resource<List<Video>>>

   suspend fun updateVideo(video: Video): Flow<Resource<Unit>>

   suspend fun deleteVideo(video: Video): Flow<Resource<Unit>>
}