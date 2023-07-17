package com.example.tilek_shambetaliev_hw7_1.presentation.fragment.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.domain.usecases.AddVideoUseCases
import com.example.tilek_shambetaliev_hw7_1.domain.usecases.GetVideoUseCase
import com.example.tilek_shambetaliev_hw7_1.domain.utils.Resource
import com.example.tilek_shambetaliev_hw7_1.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val getVideoUseCase: GetVideoUseCase,
    private val addVideoUseCase: AddVideoUseCases,
) : ViewModel() {

    private val _getAllFamilyStates = MutableStateFlow<UiState<List<Video>>>(UiState.EmptyState())
    val getAllFamilyStates = _getAllFamilyStates.asStateFlow()

    fun addVideo(video: Video){
        viewModelScope.launch(Dispatchers.IO) {
            addVideoUseCase.addVideo(video = video)
        }
    }

    fun getAllVideo() {
        viewModelScope.launch {
            getVideoUseCase.getVideo().collect() {
                when (it) {
                    is Resource.Loading -> {
                        _getAllFamilyStates.value = UiState.Loading()
                    }

                    is Resource.Success -> {
                        _getAllFamilyStates.value = UiState.Success(it.data as List<Video>)
                    }

                    is Resource.Error -> {
                        _getAllFamilyStates.value = UiState.Error(it.message ?: "")
                    }
                }
            }
        }
    }
}