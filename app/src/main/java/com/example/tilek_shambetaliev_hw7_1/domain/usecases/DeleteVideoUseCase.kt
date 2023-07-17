package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository

class DeleteVideoUseCase(private val videoRepository: VideoRepository) {
    suspend fun execute(video: Video) {
        videoRepository.deleteVideo(video)
    }
}