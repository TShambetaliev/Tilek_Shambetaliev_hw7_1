package com.example.tilek_shambetaliev_hw7_1.domain.repositories

import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity

interface VideoRepository {

    fun addVideo(videoEntity: VideoEntity)

    fun getVideo(): List<VideoEntity>

    fun updateVideo(videoEntity: VideoEntity)

    fun deleteVideo(videoEntity: VideoEntity)
}