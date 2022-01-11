package com.example.havit.ui.home

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.havit.databinding.ItemHomeCategoryListBinding
import com.example.havit.databinding.ItemHomeCategoryRecyclerviewBinding

class HomeCategoryViewPagerAdapter:
    RecyclerView.Adapter<HomeCategoryViewPagerAdapter.HomeCategoryViewHolder>() {

    val categoryList = mutableListOf<HomeCategoryListData>()
    private var callbackChangeBackground: Drawable? = null

    class HomeCategoryViewHolder(private val binding: ItemHomeCategoryRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: HomeCategoryListData, position: Int) {
            val rvCategoryAdapter = HomeCategoryAdapter()
            binding.rvCategory.adapter = rvCategoryAdapter
            rvCategoryAdapter.categoryList.addAll(
                data.categoryListData
            )
            rvCategoryAdapter.notifyDataSetChanged()
        }
    }

    fun setCallbackChangeItemBackground(drawable: Drawable?) {
        callbackChangeBackground = drawable
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoryViewHolder {
        val binding = ItemHomeCategoryRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return HomeCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeCategoryViewHolder, position: Int) {
        holder.onBind(categoryList[position], position)

        if (position == 0)
            holder.itemView.background = callbackChangeBackground
            // else
            // background 기본으로 바꾸는 함수
     }

    override fun getItemCount(): Int = categoryList.size
}