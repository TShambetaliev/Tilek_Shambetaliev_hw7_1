package com.example.tilek_shambetaliev_hw7_1.domain.repositories

import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    fun addVideo(video: Video): Flow<Resource<Unit>>

    fun getVideo(): Flow<Resource<List<Video>>>

    fun getFamilyFromLast(): Flow<Resource<List<Video>>>
    fun getFamilySortByName(): Flow<Resource<List<Video>>>

    fun updateVideo(video: Video): Flow<Resource<Unit>>

    fun deleteVideo(video: Video): Flow<Resource<Unit>>
}