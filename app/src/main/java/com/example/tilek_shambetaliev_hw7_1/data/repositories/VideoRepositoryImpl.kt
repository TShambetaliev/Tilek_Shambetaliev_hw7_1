package com.example.tilek_shambetaliev_hw7_1.data.repositories

import com.example.tilek_shambetaliev_hw7_1.data.local.VideoDao
import com.example.tilek_shambetaliev_hw7_1.data.mappers.toEntity
import com.example.tilek_shambetaliev_hw7_1.data.mappers.toVideo
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.repositories.VideoRepository
import com.example.tilek_shambetaliev_hw7_1.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class VideoRepositoryImpl(private val videoDao: VideoDao) : VideoRepository {
    override suspend fun addVideo(video: Video): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = videoDao.addVideo(video.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getVideo(): Flow<Resource<List<Video>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = videoDao.getVideo()
                val data = list.map { it.toVideo() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getVideoFromLast(): Flow<Resource<List<Video>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = videoDao.getVideoFromLast()
                val data = list.map { it.toVideo() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getVideoSortByName(): Flow<Resource<List<Video>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = videoDao.getFVideoSortByName()
                val data = list.map { it.toVideo() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun updateVideo(video: Video): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = videoDao.updateVideo(video.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteVideo(video: Video): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = videoDao.deleteVideo(video.toEntity())
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(
                    Resource.Error(e.localizedMessage ?: "unknown message")
                )
            }
        }.flowOn(Dispatchers.IO)
    }

}