package com.example.havit.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.databinding.ItemHomeCategoryListBinding

class HomeCategoryAdapter : RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {
    val categoryList = mutableListOf<HomeCategoryData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeCategoryAdapter.HomeCategoryViewHolder {
        val binding = ItemHomeCategoryListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return HomeCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeCategoryAdapter.HomeCategoryViewHolder,
        position: Int
    ) {
        holder.onBind(categoryList[position])
    }

    override fun getItemCount(): Int = categoryList.size

    class HomeCategoryViewHolder(private val binding: ItemHomeCategoryListBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun onBind(data : HomeCategoryData) {
                binding.tvTitle.text = data.title
                binding.tvCount.text = data.count.toString()
            }
        }
}