package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository

class DeleteVideoUseCase(private val videoRepository: VideoRepository) {
    fun execute(videoEntity: VideoEntity) {
        videoRepository.deleteVideo(videoEntity)
    }
}