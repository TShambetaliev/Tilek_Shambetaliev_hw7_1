package com.example.tilek_shambetaliev_hw7_1.presentation.fragment.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.tilek_shambetaliev_hw7_1.databinding.FragmentDetailBinding
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    private lateinit var binding : FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getVideo()
        initClickListeners()
    }

    private fun initClickListeners() {
        with(binding) {
            val video = (arguments?.getSerializable("key")) as Video
            btnUpdate.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.updateVideo(
                        Video(
                            id = video.id,
                            name = binding.etName.text.toString(),
                            time = binding.etTime.text.toString(),
                            tema = binding.etTema.text.toString()
                        )
                    )
                }
                findNavController().navigateUp()
            }
            btnDelete.setOnClickListener {
                viewModel.viewModelScope.launch {
                    viewModel.deleteVideo(video)
                }
                findNavController().navigateUp()
            }
        }
    }

    private fun getVideo() {
        with(binding){
            val video = (arguments?.getSerializable("key")) as Video
            etName.setText(video.name)
            etTime.setText(video.time)
            etTema.setText(video.tema)
        }
    }
}