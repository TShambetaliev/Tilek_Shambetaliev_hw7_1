package com.example.tilek_shambetaliev_hw7_1.presentation.fragment.video

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.tilek_shambetaliev_hw7_1.R
import com.example.tilek_shambetaliev_hw7_1.databinding.FragmentVideoBinding
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video
import com.example.tilek_shambetaliev_hw7_1.presentation.fragment.video.adapter.VideoAdapter
import com.example.tilek_shambetaliev_hw7_1.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VideoFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private val viewModel by viewModels<VideoViewModel>()
    private val adapter = VideoAdapter(this::onClick)

    private fun onClick(video: Video) {
        findNavController().navigate(
            R.id.detailFragment,
            bundleOf("key" to video)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        viewModelListener()
    }

    private fun setOnClickListeners() {
        with(binding) {
            btnSave.setOnClickListener {
                viewModel.addVideo(
                    Video(
                        name = etName.text.toString(),
                        time = etTime.text.toString(),
                        tema = etTema.text.toString()
                    )
                )
                Toast.makeText(requireContext(), "item is add ${Video(
                    name = etName.text.toString(),
                    time = etTime.text.toString(),
                    tema = etTema.text.toString()
                )}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun viewModelListener() {
        viewModel.getAllVideo()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getAllFamilyStates.collect {
                when (it) {
                    is UiState.EmptyState -> {
                        Toast.makeText(requireContext(), "Empty state", Toast.LENGTH_SHORT).show()
                    }

                    is UiState.Error -> {
                        binding.progressbar.isVisible = false
                        Toast.makeText(requireContext(), "Error ${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }

                    is UiState.Loading -> {
                        binding.progressbar.isVisible = true
                    }

                    is UiState.Success -> {
                        binding.progressbar.isVisible = false
                        binding.rvFamily.adapter = adapter
                        adapter.addTasks(it.data)
                        Toast.makeText(requireContext(), "Error ${it.data}", Toast.LENGTH_SHORT)
                    }
                }
            }
        }
    }
}