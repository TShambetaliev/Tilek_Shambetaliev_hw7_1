package com.example.tilek_shambetaliev_hw7_1.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tilek_shambetaliev_hw7_1.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}