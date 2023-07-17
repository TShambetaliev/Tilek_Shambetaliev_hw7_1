package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository
import com.example.tilek_shambetaliev_hw7_1.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetVideoUseCase(
    private val videoRepository: VideoRepository
) {

    fun getContacts(): Flow<Resource<List<Video>>> {
        return videoRepository.getVideo()
    }
}