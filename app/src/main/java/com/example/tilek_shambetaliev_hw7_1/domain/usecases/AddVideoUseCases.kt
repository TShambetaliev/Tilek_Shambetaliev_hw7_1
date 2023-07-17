package com.example.tilek_shambetaliev_hw7_1.domain.usecases

import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository

class AddVideoUseCases (
    private val contactRepository: VideoRepository
    ){

    suspend fun addVideo(video: Video){
        contactRepository.addVideo(video)
    }
}