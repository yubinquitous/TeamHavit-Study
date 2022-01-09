package com.example.havit.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.databinding.ItemHomeCategoryListBinding
import com.example.havit.databinding.ItemHomeContentsListBinding

class HomeContentsAdapter : RecyclerView.Adapter<HomeContentsAdapter.HomeContentsViewHolder>(){
    val contentsList = mutableListOf<HomeContentsData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeContentsAdapter.HomeContentsViewHolder {
        val binding = ItemHomeContentsListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return HomeContentsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeContentsAdapter.HomeContentsViewHolder,
        position: Int
    ) {
        holder.onBind(contentsList[position])
    }

    override fun getItemCount(): Int = contentsList.size

    class HomeContentsViewHolder(private val binding: ItemHomeContentsListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : HomeContentsData) {
            binding.tvTitle.text = data.title
            binding.tvHeader.text = data.header
            binding.tvTime.text = data.time
        }
    }
}