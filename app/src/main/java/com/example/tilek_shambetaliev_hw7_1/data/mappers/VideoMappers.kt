package com.example.tilek_shambetaliev_hw7_1.data.mappers

import com.example.tilek_shambetaliev_hw7_1.data.models.VideoEntity
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video

fun Video.toEntity() : VideoEntity{
    return VideoEntity(id = id, name = name, number = number, address = address)
}

fun VideoEntity.toVideo() : Video{
    return Video(id = id, name = name, number = number, address = address)
}