package com.example.tilek_shambetaliev_hw7_1.data.local

import androidx.room.*
import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addVideo(videoEntity: VideoEntity)

    @Query("SELECT * FROM contacts")
    suspend fun getVideo(): List<VideoEntity>

    @Query("SELECT * FROM contacts ORDER BY family_id DESC")
    suspend fun getVideoFromLast(): List<VideoEntity>

    @Query("SELECT * FROM contacts ORDER BY family_name ASC")
    suspend fun getFVideoSortByName(): List<VideoEntity>

    @Update
    suspend fun updateVideo(videoEntity: VideoEntity)

    @Delete
    suspend fun deleteVideo(videoEntity: VideoEntity)
}