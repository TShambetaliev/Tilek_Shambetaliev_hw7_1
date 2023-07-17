package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository

class UpdateVideoUseCase(private val contactRepository: VideoRepository) {
    fun execute(videoEntity: VideoEntity) {
        contactRepository.updateVideo(videoEntity)
    }
}