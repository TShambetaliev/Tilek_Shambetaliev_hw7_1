package com.example.tilek_shambetaliev_hw7_1.presentation.fragment.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.usecases.DeleteVideoUseCase
import com.example.tilek_shambetaliev_hw7_1.domain.usecases.UpdateVideoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val updateFamilyUseCase: UpdateVideoUseCase,
    private val deleteFamilyUseCase: DeleteVideoUseCase
) : ViewModel() {

    suspend fun updateVideo(video: Video) {
        viewModelScope.launch(Dispatchers.IO) {
            updateFamilyUseCase.execute(video)
        }
    }

    suspend fun deleteVideo(video: Video) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteFamilyUseCase.execute(video)
        }
    }
}