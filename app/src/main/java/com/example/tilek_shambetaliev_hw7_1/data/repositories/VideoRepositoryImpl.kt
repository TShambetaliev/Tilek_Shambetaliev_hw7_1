package com.example.tilek_shambetaliev_hw7_1.data.repositories

import com.example.tilek_shambetaliev_hw7_1.data.local.VideoDao
import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository

class VideoRepositoryImpl(private val contactDao: VideoDao) : VideoRepository {

    override fun addVideo(videoEntity: VideoEntity) {
        contactDao.addVideo(videoEntity)
    }

    override fun getVideo(): List<VideoEntity> {
        return contactDao.getVideo()
    }

    override fun updateVideo(videoEntity: VideoEntity) {
        contactDao.updateVideo(videoEntity)
    }

    override fun deleteVideo(videoEntity: VideoEntity) {
        contactDao.deleteVideo(videoEntity)
    }
}