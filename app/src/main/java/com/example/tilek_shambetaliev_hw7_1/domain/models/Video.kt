package com.example.tilek_shambetaliev_hw7_1.domain.models

import java.io.Serializable


data class Video(
    val id: Int = 0,
    val name: String,
    val time: String,
    val tema: String
): Serializable