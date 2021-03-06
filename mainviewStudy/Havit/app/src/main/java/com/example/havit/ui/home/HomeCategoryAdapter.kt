package com.example.havit.ui.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.R
import com.example.havit.databinding.ItemHomeCategoryListBinding

class HomeCategoryAdapter : RecyclerView.Adapter<HomeCategoryAdapter.HomeCategoryViewHolder>() {
    val categoryList = mutableListOf<HomeCategoryData>()
    private var callbackChangeBackground: Drawable? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeCategoryViewHolder {
        val binding = ItemHomeCategoryListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return HomeCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: HomeCategoryViewHolder,
        position: Int
    ) {
        holder.onBind(categoryList[position])

        if (categoryList[position].title == "전체")
            holder.itemView.background = callbackChangeBackground
    }

    fun setCallbackChangeItemBackground(drawable: Drawable?) {
        callbackChangeBackground = drawable
    }

    override fun getItemCount(): Int = categoryList.size

    class HomeCategoryViewHolder(private val binding: ItemHomeCategoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeCategoryData) {
            binding.tvTitle.text = data.title
            binding.tvCount.text = data.count.toString()
        }
    }
}