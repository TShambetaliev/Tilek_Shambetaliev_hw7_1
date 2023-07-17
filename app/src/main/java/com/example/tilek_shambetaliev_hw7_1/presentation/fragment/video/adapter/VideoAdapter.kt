package com.example.tilek_shambetaliev_hw7_1.presentation.fragment.video.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tilek_shambetaliev_hw7_1.databinding.ItemVideoBinding
import com.example.tilek_shambetaliev_hw7_1.domain.models.Video

class VideoAdapter(
    private val onClick: (video: Video) -> Unit
) : Adapter<VideoAdapter.FamilyViewHolder>() {
    private val familyList = arrayListOf<Video>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        return FamilyViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun addTasks(family: List<Video>) {
        familyList.clear()
        familyList.addAll(family)
        notifyDataSetChanged()
    }

    fun getFamily(position: Int): Video {
        return familyList[position]
    }

    override fun getItemCount(): Int = familyList.size

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        holder.onBind(video = familyList[position])
    }

    inner class FamilyViewHolder(private val binding: ItemVideoBinding) :
        ViewHolder(binding.root) {

        fun onBind(video: Video) {
            with(binding) {
                tvName.text = video.name
                tvTime.text = video.time
                tvTema.text = video.tema
            }
            itemView.setOnClickListener {
                onClick(getFamily(adapterPosition))
            }
        }
    }
}